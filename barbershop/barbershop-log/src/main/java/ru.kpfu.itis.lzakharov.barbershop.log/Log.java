package ru.kpfu.itis.lzakharov.barbershop.log;

import org.apache.log4j.Logger;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;

@Aspect
public class Log {
    private static Logger logger = Logger.getLogger(Log.class);

    @Before(value = "execution(public * *(..))")
    public void logBeforeMethod() {
        logger.trace("Method invoked:");
    }

    @Around(value = "execution(public * *(..))")
    public Object logAroundMethod(ProceedingJoinPoint joinPoint) {
        try {
            long start = System.nanoTime();
            Object result = joinPoint.proceed();
            long end = System.nanoTime();
            logger.info(String.format("%s took %d ns", joinPoint.getSignature(), (end - start)));
            return result;
        } catch (Throwable e) {
            throw new RuntimeException(e);
        }
    }

}
