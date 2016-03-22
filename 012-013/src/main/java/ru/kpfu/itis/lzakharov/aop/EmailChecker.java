package ru.kpfu.itis.lzakharov.aop;

import org.apache.commons.validator.routines.EmailValidator;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;

@Aspect
public class EmailChecker {
    @Around(value = "execution(* *..*.setEmail(String))")
    public void checkEmail(ProceedingJoinPoint jp) throws Throwable {
        EmailValidator validator = EmailValidator.getInstance();
        if (validator.isValid(jp.getArgs()[0].toString())) {
            jp.proceed();
        }

        System.err.println("The e-mail address is not valid");
    }
}
