package ru.kpfu.itis.lzakharov.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Аспект устанавливает кодировку в response
 */
@Aspect
public class ResponseConfig {
    @Before(value = "execution(* *..*.doGet(HttpServletRequest, HttpServletResponse)) && args(request, response)")
    public void config(ProceedingJoinPoint jp, HttpServletRequest request, HttpServletResponse response) {
	response.setCharacterEncoding("UTF-8");
    }
}
