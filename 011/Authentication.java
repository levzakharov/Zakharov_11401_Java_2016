package ru.kpfu.itis.lzakharov.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * Аспект навешивает проверку аутентификации на каждый get и post запрос
 */
@Aspect
public class Authentication {
    @Around(value = "execution(* *..*.doGet(HttpServletRequest, HttpServletResponse)) && args(request, response) " +
            "|| execution(* *..*.doPost(HttpServletRequest, HttpServletResponse)) && args(request, response) ")
    public void authenticate(ProceedingJoinPoint jp, HttpServletRequest request, HttpServletResponse response)
            throws Throwable {
        HttpSession session = ((HttpServletRequest)request).getSession();
        if (session.getAttribute("current_user") == null) {
            try {
                ((HttpServletResponse)response).sendRedirect("/login");
            } catch (IOException e) {
                e.printStackTrace();
            }
        } else {
            jp.proceed();
        }
    }
}
