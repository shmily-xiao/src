package com.zhujieAndAop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class MsgAspect {


    @Pointcut("@annotation(com.zhujieAndAop.TestA)")
    public void msg() {
        System.out.println("000");
    }

    @Before("msg()")
    public void doBefore(JoinPoint joinPoint) {
        for (Object object : joinPoint.getArgs()) {
            //if (
            //    object instanceof MultipartFile
            //        || object instanceof HttpServletRequest
            //        || object instanceof HttpServletResponse
            //) {
            //    continue;
            //}

            System.out.println(object);

            System.out.println(joinPoint.getTarget().getClass().getName() + "." + joinPoint.getSignature().getName());

        }
    }

}
