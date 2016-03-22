package ru.kpfu.itis.lzakharov.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;

@Aspect
public class StatementChecker {
    @Around(value = "execution(* *..Statement.execute(String))")
    public void checkStatement(ProceedingJoinPoint jp) throws Throwable {
        if (!hasInjection(jp.getArgs()[0].toString())) {
            jp.proceed();
        }
    }

    private boolean hasInjection(String s) {
        // check
        return false;
    }
}
