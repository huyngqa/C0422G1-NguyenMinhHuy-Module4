package com.exercise.controller;

import com.exercise.service.ICondimentsService;
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
    private ICondimentsService iCondimentsService;

    @GetMapping("")
    public String showListCondiments(Model model) {
        List<String> condimentsList = iCondimentsService.getAllCondiments();
        model.addAttribute("condimentsList", condimentsList);
        return "index";
    }

    @PostMapping("/choose-condiments")
    public String showChooseCondiments(@RequestParam String[] condiments, Model model) {
        model.addAttribute("condiments", condiments);
        return "result";
    }
}
