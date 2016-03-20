package ru.kpfu.itis.lzakharov.webapp.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class HelloController {
    @RequestMapping(value = "/hi/{x:(a|b)}", method = RequestMethod.GET)
    public String hiPage(ModelMap model, @PathVariable String x, @RequestParam(required = false) String name) {
        System.out.println(x);
        model.put("time", new java.util.Date());
        model.put("name", name);
        return "hi";
    }
}
