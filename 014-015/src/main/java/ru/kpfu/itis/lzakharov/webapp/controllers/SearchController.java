package ru.kpfu.itis.lzakharov.webapp.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class SearchController {
    @RequestMapping(value = "/{site}/search")
    public String search(ModelMap model, @PathVariable String site) {
        String action;
        String name;

        switch (site) {
            case "baidu":
                action = "http://www.baidu.com/s";
                name = "wd";
                break;
            case "bing":
                action = "http://www.bing.com/search";
                name = "q";
                break;
            case "yahoo":
                action = "https://search.yahoo.com/search";
                name = "p";
                break;
            case "aol":
                action = "http://search.aol.com/aol/search";
                name = "q";
                break;
            default:
                return "/error-404";
        }

        model.put("action", action);
        model.put("name", name);

        return "search";
    }
}
