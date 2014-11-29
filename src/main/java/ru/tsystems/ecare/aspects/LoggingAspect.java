package ru.tsystems.ecare.aspects;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Arrays;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterThrowing;

/**
 * Will log every invocation of methods in @Repository, @Controller or
 * @Service annotated beans.
 */
@Aspect
public class LoggingAspect {

    private static final Logger LOGGER
            = LoggerFactory.getLogger(LoggingAspect.class);

    @Pointcut("within(@org.springframework.stereotype.Controller *)")
    public final void controller() {
    }

    @Pointcut("within(@org.springframework.stereotype.Service *)")
    public final void service() {
    }

    @Pointcut("within(@org.springframework.stereotype.Repository *)")
    public final void repository() {
    }

    @Pointcut("execution(* *(..))")
    public void methodPointcut() {
    }

    @Pointcut("within("
            + "@org.springframework.web.bind.annotation.RequestMapping *)")
    public final void requestMapping() {
    }

    @Before("controller() && methodPointcut() && requestMapping()")
    public final void aroundControllerMethod(final JoinPoint joinPoint)
            throws Throwable {
        LOGGER.info("Invoked: " + niceName(joinPoint));
    }

    @After("controller() && methodPointcut() && requestMapping()")
    public final void afterControllerMethod(final JoinPoint joinPoint) {
        LOGGER.info("Finished: " + niceName(joinPoint));
    }
    
    @Before("service() && methodPointcut()")
    public final void aroundServiceMethod(final JoinPoint joinPoint)
            throws Throwable {
        LOGGER.info("Invoked: " + niceName(joinPoint));
    }

    @After("service() && methodPointcut()")
    public final void afterServiceMethod(final JoinPoint joinPoint) {
        LOGGER.info("Finished: " + niceName(joinPoint));
    }
    
    @Before("repository() && methodPointcut()")
    public final void aroundRepositoryMethod(final JoinPoint joinPoint)
            throws Throwable {
        LOGGER.info("Invoked: " + niceName(joinPoint));
    }

    @After("repository() && methodPointcut()")
    public final void afterRepositoryMethod(final JoinPoint joinPoint) {
        LOGGER.info("Finished: " + niceName(joinPoint));
    }

    private String niceName(final JoinPoint joinPoint) {
        return joinPoint.getTarget().getClass()
                + "#" + joinPoint.getSignature().getName()
                + "\n\targs:" + Arrays.toString(joinPoint.getArgs());
    }

//    @AfterThrowing("within(ru.tsystems.ecare.*)")
//    public final void logExceptions(final JoinPoint joinPoint) {
//        LOGGER.info("Exception thrown in " + niceName(joinPoint));
//    }
}
