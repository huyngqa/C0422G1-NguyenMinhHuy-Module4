package com.exercise.repository;

import java.util.List;

public interface CondimentsRepository {
    List<String> getAllCondiments();
    List<String> chooseCondiments(String[] condiment);
}
