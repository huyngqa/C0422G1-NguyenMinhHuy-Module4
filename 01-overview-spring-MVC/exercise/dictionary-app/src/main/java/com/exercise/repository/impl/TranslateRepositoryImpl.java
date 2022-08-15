package com.exercise.repository.impl;

import com.exercise.repository.TranslateRepository;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.Map;

@Repository
public class TranslateRepositoryImpl implements TranslateRepository {
    private static Map<String, String> dictionaryMap = new HashMap<>();

    static {
        dictionaryMap.put("one", "một");
        dictionaryMap.put("two", "hai");
        dictionaryMap.put("three", "ba");
        dictionaryMap.put("four", "bốn");
        dictionaryMap.put("five", "năm");
    }

    @Override
    public String translateWords(String words) {
        if (dictionaryMap.containsKey(words.toLowerCase())) {
            return dictionaryMap.get(words.toLowerCase());
        }
        return "Từ này chưa có trong từ điển";
    }
}
