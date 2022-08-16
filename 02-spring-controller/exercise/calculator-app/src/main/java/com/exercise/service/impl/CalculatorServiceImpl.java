package com.exercise.service.impl;

import com.exercise.service.CalculatorService;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class CalculatorServiceImpl implements CalculatorService {

    @Override
    public Map<String, String> getCalculateResult(int number1, int number2, String operator) {
        Map<String, String> map = new HashMap<>();
        switch (operator) {
            case "+":
                map.put("result", number1 + " + " + number2 + " = " + (number1 + number2));
                break;
            case "-":
                map.put("result", number1 + " - " + number2 + " = " + (number1 - number2));
                break;
            case "*":
                map.put("result", number1 + " * " + number2 + " = " + (number1 * number2));
                break;
            case "/":
                if (number2 == 0) {
                    map.put("numberErr", "cannot be divided by zero");
                } else {
                    map.put("result", number1 + " / " + number2 + " = " + (number1 / number2));
                }
                break;
        }
        return map;
    }
}
