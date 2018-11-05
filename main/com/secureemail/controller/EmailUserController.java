package com.secureemail.controller;

import com.secureemail.domain.User;
import com.secureemail.security.Md5;
import com.secureemail.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.function.Consumer;

/**
 * Created by simpletour_Jenkin on 2015/11/9.
 */
@Controller
public class EmailUserController {

    @Autowired
    private UserService userService;

    @RequestMapping(value = "/user/front/login",method = RequestMethod.GET)
    public String login(){
        return "/email/front/login";
    }

    @RequestMapping(value = "/user/front/login",method = RequestMethod.POST)
    public String login(Model model,User user,HttpServletRequest request){
        HttpSession session = request.getSession();
        User userTemp = userService.find(user);
        String tempPassword = Md5.messageDigest(user.getUserPw() + userTemp.getSalt());
        if (tempPassword.equalsIgnoreCase(userTemp.getUserPw())){
            session.setAttribute("userName",userTemp.getUserName());
            session.setAttribute("userId",userTemp.getUserId());
            return "";
        }
        model.addAttribute("loginError","用户名或密码错误");
        return "";
    }

    @RequestMapping(value = "/user/front/register",method = RequestMethod.GET)
    public String register(){
        return "/email/front/register";
    }

    @RequestMapping(value = "user/front/register",method = RequestMethod.POST)
    public String register(Model model,User user,HttpServletRequest request){

        return "redirect:/user/front/login";
    }

}
