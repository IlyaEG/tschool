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
 *
 * @Service annotated beans.
 */
@Aspect
public class LoggingAspect {

    private static final Logger LOGGER
            = LoggerFactory.getLogger(LoggingAspect.class);

    /*
     @Pointcut("within(@org.springframework.stereotype.Controller *)")
     public final void controller() {
     }
     //*/
    @Pointcut("within(@org.springframework.stereotype.Service *)")
    public final void service() {
    }

    @Pointcut("within(@org.springframework.stereotype.Repository *)")
    public final void repository() {
    }
//*/

    @Pointcut("execution(* *(..))")
    public void methodPointcut() {
    }
    /*
     @Pointcut("within("
     + "@org.springframework.web.bind.annotation.RequestMapping *)")
     public final void requestMapping() {
     }
     //*/
    /*
     @Pointcut("within(ru.tsystems.ecare.controller.*)")
     private void inEcare() {}


     @Before("methodPointcut() && inEcare()")
     public final void beforeControllerMethod(final JoinPoint joinPoint)
     throws Throwable {
     LOGGER.info("Invoked: " + niceName(joinPoint));
     }

     /*

     @Before("controller() && methodPointcut() && inEcare()")
     public final void beforeControllerMethod(final JoinPoint joinPoint)
     throws Throwable {
     LOGGER.info("Invoked: " + niceName(joinPoint));
     }
     //*/
    /*
     @AfterReturning("controller() && methodPointcut()")
     public final void afterControllerMethod(final JoinPoint joinPoint) {
     LOGGER.info("Finished: " + niceName(joinPoint));
     }
     */

    @Before("service() && methodPointcut()")
    public final void beforeServiceMethod(final JoinPoint joinPoint)
            throws Throwable {
        LOGGER.info("Invoked: " + niceName(joinPoint));
    }

    @AfterReturning("service() && methodPointcut()")
    public final void afterServiceMethod(final JoinPoint joinPoint) {
        LOGGER.info("Finished: " + niceName(joinPoint));
    }

    @Before("repository() && methodPointcut()")
    public final void beforeRepositoryMethod(final JoinPoint joinPoint)
            throws Throwable {
        LOGGER.info("Invoked: " + niceName(joinPoint));
    }

    @AfterReturning("repository() && methodPointcut()")
    public final void afterRepositoryMethod(final JoinPoint joinPoint) {
        LOGGER.info("Finished: " + niceName(joinPoint));
    }

    @AfterThrowing("within(ru.tsystems.ecare.*)")
    public final void logExceptions(final JoinPoint joinPoint) {
        LOGGER.info("Exception thrown in " + niceName(joinPoint));
    }

    private String niceName(final JoinPoint joinPoint) {
        return joinPoint.getTarget().getClass()
                + "#" + joinPoint.getSignature().getName()
                + "\n\targs:" + Arrays.toString(joinPoint.getArgs());
    }
}
