package com.exercise.repository.impl;

import com.exercise.repository.CondimentsRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class CondimentsRepositoryImpl implements CondimentsRepository {

    private static List<String> condimentsList = new ArrayList<>();
    static {
        condimentsList.add("Lettuce");
        condimentsList.add("Tomato");
        condimentsList.add("Mustard");
        condimentsList.add("Sprouts");
    }

    @Override
    public List<String> getAllCondiments() {
        return condimentsList;
    }
}
