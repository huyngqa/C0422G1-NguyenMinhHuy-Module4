package com.exercise.controller;

import com.exercise.service.ITranslateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class TranslateController {

    @Autowired
    private ITranslateService iTranslateService;

    @GetMapping("/")
    public String showFormTranslate() {
        return "index";
    }

    @GetMapping("/trans")
    public String translateWords(@RequestParam String words, Model model) {
        String result = iTranslateService.translateWords(words);
        model.addAttribute("words",words);
        model.addAttribute("result", result);
        return "index";
    }
}
