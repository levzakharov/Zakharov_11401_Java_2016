package ru.kpfu.itis.lzakharov.webapp.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Controller
public class ResultController {
    @RequestMapping("/result")
    public String result(ModelMap model, HttpServletRequest request) {
        HttpSession session = request.getSession();
        String description = "";
        String result = "";

        switch (session.getAttribute("operation").toString()) {
            case "symbols-cnt":
                description = "Количество символов: ";
                result = symbolsCounter(session.getAttribute("text").toString());
                break;
            case "words-cnt":
                description = "Количество слов: ";
                result = wordsCounter(session.getAttribute("text").toString());
                break;
            case "sentences-cnt":
                description = "Количество предложений: ";
                result = sentencesCounter(session.getAttribute("text").toString());
                break;
            case "paragraphs-cnt":
                description = "Количество параграфов: ";
                result = paragraphsCounter(session.getAttribute("text").toString());
                break;
        }

        model.put("description", description);
        model.put("result", result);

        return "result";
    }

    private String paragraphsCounter(String text) {
        return String.valueOf(text.split("\\t+").length);
    }

    private String sentencesCounter(String text) {
        return String.valueOf(text.split("\\.|!|\\?").length);
    }

    private String wordsCounter(String text) {
        return String.valueOf((text.split(" ")).length);
    }

    private String symbolsCounter(String text) {
        return String.valueOf(text.length());
    }
}
