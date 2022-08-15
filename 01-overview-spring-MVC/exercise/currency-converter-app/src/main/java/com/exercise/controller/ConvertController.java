package com.exercise.controller;

import com.exercise.service.ConvertService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class ConvertController {

    @Autowired
    private ConvertService convertService;

    @GetMapping("/")
    public String showFormConvertCurrency() {
        return "index";
    }

    @GetMapping("/convert")
    public String resultConvert(@RequestParam double money, Model model) {
        double result = convertService.convertCurrency(money);
        model.addAttribute("money", money);
        model.addAttribute("result", result + "đ");
        return "index";
    }
}
