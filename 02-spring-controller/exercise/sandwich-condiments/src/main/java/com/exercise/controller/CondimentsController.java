package com.exercise.controller;

import com.exercise.service.CondimentsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class CondimentsController {

    @Autowired
    private CondimentsService condimentsService;

    @GetMapping("")
    public String showListCondiments(Model model) {
        List<String> condimentsList = condimentsService.getAllCondiments();
        model.addAttribute("condimentsList", condimentsList);
        return "index";
    }

    @PostMapping("/choose-condiments")
    public String showChooseCondiments(@RequestParam String[] condiment, Model model) {
        List<String> condimentsList = condimentsService.chooseCondiments(condiment);
        model.addAttribute("condimentsList", condimentsList);
        return "result";
    }
}
