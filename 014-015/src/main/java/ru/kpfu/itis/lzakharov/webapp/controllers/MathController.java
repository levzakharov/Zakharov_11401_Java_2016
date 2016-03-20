package ru.kpfu.itis.lzakharov.webapp.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MathController {
    @RequestMapping(value = "/add/{a:\\d+}/{b:\\d+}")
    public String add(ModelMap model, @PathVariable String a, @PathVariable String b) {
        model.put("operation", "+");
        model.put("a", a);
        model.put("b", b);
        model.put("res", String.valueOf(Integer.parseInt(a) + Integer.parseInt(b)));

        return "res";
    }

    @RequestMapping(value = "/mult/{a:\\d+}/{b:\\d+}")
    public String mult(ModelMap model, @PathVariable String a, @PathVariable String b) {
        model.put("operation", "*");
        model.put("a", a);
        model.put("b", b);
        model.put("res", String.valueOf(Integer.parseInt(a) * Integer.parseInt(b)));

        return "res";
    }
}
