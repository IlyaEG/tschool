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
 * LoogingAspect.
 * Will log every invocation of methods in @Repository or @Service
 * annotated beans.
 */
@Aspect
public class LoggingAspect {

    private static final Logger LOGGER
            = LoggerFactory.getLogger(LoggingAspect.class);

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

    /*/
     @Pointcut("execution(* *(..))")
     public void methodPointcut() {
     }
     //*/
    /*
     @Pointcut("within("
     + "@org.springframework.web.bind.annotation.RequestMapping *)")
     public final void requestMapping() {
     }
     //*/

    /*/
     @Before("methodPointcut() && inEcare()")
     public final void beforeControllerMethod(final JoinPoint joinPoint)
     throws Throwable {
     LOGGER.info("Invoked: " + niceName(joinPoint));
     }
     //*/
    /*
     @Before("controller()")
     public final void beforeControllerMethod(final JoinPoint joinPoint)
     throws Throwable {
     LOGGER.info("Invoked controller: " + niceName(joinPoint));
     }
     //*/
    /*
     @AfterReturning("controller()")
     public final void afterControllerMethod(final JoinPoint joinPoint) {
     LOGGER.info("Finished controller: " + niceName(joinPoint));
     }

     //*/
    /*
     @Around("controller()")
     public Object logTimeMethod(ProceedingJoinPoint joinPoint) throws Throwable {
     StopWatch stopWatch = new StopWatch();
     stopWatch.start();
     Object retVal = joinPoint.proceed();
     stopWatch.stop();
     StringBuilder logMessage = new StringBuilder();
     logMessage.append(joinPoint.getTarget().getClass().getName());
     logMessage.append(".");
     logMessage.append(joinPoint.getSignature().getName());
     logMessage.append("(");
     // append args
     Object[] args = joinPoint.getArgs();
     for (Object arg : args) {
     logMessage.append(arg).append(",");
     }
     if (args.length > 0) {
     logMessage.deleteCharAt(logMessage.length() - 1);
     }
     logMessage.append(")");
     logMessage.append(" execution time: ");
     logMessage.append(stopWatch.getTotalTimeMillis());
     logMessage.append(" ms");
     LOGGER.info(logMessage.toString());
     return retVal;
     }
     //*/
    @Before("service()")
    public final void beforeServiceMethod(final JoinPoint joinPoint)
            throws Throwable {
        LOGGER.info("Invoked service: " + niceName(joinPoint));
    }

    @AfterReturning("service()")
    public final void afterServiceMethod(final JoinPoint joinPoint) {
        LOGGER.info("Finished service: " + niceName(joinPoint));
    }

    @Before("repository()")
    public final void beforeRepositoryMethod(final JoinPoint joinPoint)
            throws Throwable {
        LOGGER.info("Invoked DAO: " + niceName(joinPoint));
    }

    @AfterReturning("repository()")
    public final void afterRepositoryMethod(final JoinPoint joinPoint) {
        LOGGER.info("Finished DAO: " + niceName(joinPoint));
    }

//    @AfterThrowing("inEcare()")
//    public final void logExceptions(final JoinPoint joinPoint) {
//        LOGGER.info("Exception thrown in " + niceName(joinPoint));
//    }

    private String niceName(final JoinPoint joinPoint) {
        return joinPoint.getTarget().getClass()
                + "#" + joinPoint.getSignature().getName()
                + "\n\targs:" + Arrays.toString(joinPoint.getArgs());
    }
}
