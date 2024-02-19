package com.personal.bankapidefault.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class UserAspect {

    @Before(value = "execution(* com.personal.bankapidefault.service.impl.UserServiceImpl.*(..))")
    public void beforeAdvice(JoinPoint joinPoint){
//        System.out.println("Spring Before method: " + joinPoint.getSignature());
    }
}
