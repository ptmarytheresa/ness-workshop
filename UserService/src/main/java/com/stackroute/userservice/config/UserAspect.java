package com.stackroute.userservice.config;

import java.time.LocalDate;
import java.time.LocalDateTime;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Aspect
//@Component
public class UserAspect {

    Logger log = LoggerFactory.getLogger(UserAspect.class);

    
    @Pointcut("execution(* com.stackroute.userservice.controller.UserController.adduser(..))")
    public void addAdvice() {}
 
    @Pointcut("execution(* com.stackroute.userservice.controller.UserController.view(..))")
    public void viewAdvice() {}

 
    @Pointcut("execution(* com.stackroute.userservice.controller.UserController.view(..)) && args(id)")
    public void deleteAdvice(int id) {}

     @After("viewAdvice()")
    public void afterViewCalled(JoinPoint jp) {
        log.info("Someone called view method of user at " + LocalDateTime.now());
    }

     @Around("addAdvice()")
    public Object afterSave(ProceedingJoinPoint proceedObj) throws Throwable {
        var obj = proceedObj.proceed();
        try {
            log.info("A new user got added " + obj.toString() + " on " + LocalDate.now());
        } catch (Exception e) {
            log.error("Error while logging add user event", e);
        }
        return obj;
    }

     @AfterThrowing(pointcut = "addAdvice()", throwing = "excep")
    public void handleError(Exception excep) {
        log.warn("Exception thrown in addUser: " + excep.getMessage() + " at " + LocalDate.now());
    }

     @After("deleteAdvice(id)")
    public void afterDeleteCalled(int id) {
        log.info("User with ID " + id + " was requested for deletion at " + LocalDateTime.now());
    }
}
