package ru.tsystems.ecare.aspects;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;

import java.util.Arrays;

/**
 * Will log every invocation of @RequestMapping annotated methods in @Repository
 * annotated beans.
 */
@Aspect
public class DAOLoggingAspect {

    @Pointcut("within(@org.springframework.stereotype.Repository *)")
    public void controller() {
    }

    @Pointcut("execution(* *(..))")
    public void methodPointcut() {
    }

    @Pointcut("within(@org.springframework.web.bind.annotation.RequestMapping *)")
    public void requestMapping() {
    }

    @Before("repository() && methodPointcut() && requestMapping()")
    public void aroundRepositoryMethod(JoinPoint joinPoint) throws Throwable {
        System.out.println("Invoked: " + niceName(joinPoint));
    }

    @AfterReturning("repository() && methodPointcut() && requestMapping()")
    public void afterRepositoryMethod(JoinPoint joinPoint) {
        System.out.println("Finished: " + niceName(joinPoint));
    }

    private String niceName(JoinPoint joinPoint) {
        return joinPoint.getTarget().getClass()
                + "#" + joinPoint.getSignature().getName()
                + "\n\targs:" + Arrays.toString(joinPoint.getArgs());
    }
}
