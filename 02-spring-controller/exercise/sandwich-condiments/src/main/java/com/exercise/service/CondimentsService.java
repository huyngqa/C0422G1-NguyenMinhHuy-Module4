package com.exercise.service;

import java.util.List;

public interface CondimentsService {
    List<String> getAllCondiments();
    List<String> chooseCondiments(String[] condiment);
}
