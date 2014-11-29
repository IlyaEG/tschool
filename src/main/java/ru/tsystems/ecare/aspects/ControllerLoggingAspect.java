/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ru.tsystems.ecare.aspects;

import java.util.Arrays;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Will log every invocation of @RequestMapping annotated methods in @Controller
 * annotated beans.
 */
@Aspect
public class ControllerLoggingAspect {

    private static final Logger logger
            = LoggerFactory.getLogger(ControllerLoggingAspect.class);

    @Pointcut("within(@org.springframework.stereotype.Controller *)")
    public void controller() {
    }

    @Pointcut("execution(* *(..))")
    public void methodPointcut() {
    }

    @Pointcut("within(@org.springframework.web.bind.annotation.RequestMapping *)")
    public void requestMapping() {
    }

    @Before("controller() && methodPointcut() && requestMapping()")
    public void aroundControllerMethod(JoinPoint joinPoint) throws Throwable {
        logger.info("Invoked: " + niceName(joinPoint));
    }

    @AfterReturning("controller() && methodPointcut() && requestMapping()")
    public void afterControllerMethod(JoinPoint joinPoint) {
        logger.info("Finished: " + niceName(joinPoint));
    }

    private String niceName(JoinPoint joinPoint) {
        return joinPoint.getTarget().getClass()
                + "#" + joinPoint.getSignature().getName()
                + "\n\targs:" + Arrays.toString(joinPoint.getArgs());
    }

}
