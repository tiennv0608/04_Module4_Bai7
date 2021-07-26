package com.codegym.logger;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

import java.util.Arrays;

@Component
@Aspect
public class Logger {
    @AfterThrowing(pointcut = "execution(public * com.codegym.service.impl.CommentServiceImpl.*(..))", throwing = "e")
    public void log(Exception e) {
        System.out.println("Warning:" + e.getMessage());

    }
}
