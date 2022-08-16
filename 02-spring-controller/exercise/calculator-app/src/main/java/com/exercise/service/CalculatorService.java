package com.exercise.service;

import java.util.Map;

public interface CalculatorService {
    Map<String, String> getCalculateResult(int number1, int number2, String operator);
}
