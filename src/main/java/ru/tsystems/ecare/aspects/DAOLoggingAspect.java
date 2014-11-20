package ru.tsystems.ecare.aspects;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Arrays;

/**
 * Will log every invocation of @RequestMapping annotated methods in @Repository
 * annotated beans.
 */
@Aspect
public class DAOLoggingAspect {

    private static final Logger logger
            = LoggerFactory.getLogger(DAOLoggingAspect.class);

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
        logger.info("Invoked: " + niceName(joinPoint));
    }

    @AfterReturning("repository() && methodPointcut() && requestMapping()")
    public void afterRepositoryMethod(JoinPoint joinPoint) {
        logger.info("Finished: " + niceName(joinPoint));
    }

    private String niceName(JoinPoint joinPoint) {
        return joinPoint.getTarget().getClass()
                + "#" + joinPoint.getSignature().getName()
                + "\n\targs:" + Arrays.toString(joinPoint.getArgs());
    }
}
