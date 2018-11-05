package com.secureemail.service.impl;

import com.secureemail.dao.UserDao;
import com.secureemail.domain.User;
import com.secureemail.service.UserService;

/**
 * Created by simpletour_Jenkin on 2015/11/9.
 */
public class UserServiceImpl implements UserService {


    private UserDao  userDao;

    @Override
    public User find(User user) {
        return userDao.find(user);
    }

    @Override
    public int update(User user) {
        return userDao.update(user);
    }

    @Override
    public int insert(User user) {
        return userDao.insert(user);
    }

    @Override
    public int delete(User user) {
        return userDao.delete(user);
    }

    public void setUserDao(UserDao userDao) {
        this.userDao = userDao;
    }
}
