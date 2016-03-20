package ru.kpfu.itis.lzakharov.webapp.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Controller
public class ProcessController {
    @RequestMapping(value = "/process", method = RequestMethod.GET)
    public String processGet() {
        return "process";
    }

    @RequestMapping(value = "/process", method = RequestMethod.POST)
    public String process(ModelMap model, HttpServletRequest request) {
        HttpSession session = request.getSession();

        session.setAttribute("text", request.getParameter("text"));
        session.setAttribute("operation", request.getParameter("operation"));

        return "redirect:/result";
    }
}
