package com.exercise.service;

import java.util.Map;

public interface ICalculatorService {
    Map<String, String> calculate(int number1, int number2, String operator);
}
