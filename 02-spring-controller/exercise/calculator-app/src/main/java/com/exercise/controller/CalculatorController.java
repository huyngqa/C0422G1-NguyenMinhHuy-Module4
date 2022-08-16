package com.exercise.controller;

import com.exercise.service.ICalculatorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Map;

@Controller
public class CalculatorController {

    @Autowired
    private ICalculatorService iCalculatorService;

    @GetMapping("")
    public String showCalculator() {
        return "index";
    }

    @GetMapping("/calculate")
    public String getCalculateResult(@RequestParam int number1,
                                     @RequestParam int number2,
                                     @RequestParam String operator,
                                     ModelMap modelMap) {
        Map<String, String> mapResult = iCalculatorService.calculate(number1, number2, operator);
        modelMap.addAllAttributes(mapResult);
        return "index";
    }
}
