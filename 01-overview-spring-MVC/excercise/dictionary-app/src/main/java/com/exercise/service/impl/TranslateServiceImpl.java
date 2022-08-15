package com.exercise.service.impl;

import com.exercise.repository.TranslateRepository;
import com.exercise.service.TranslateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TranslateServiceImpl implements TranslateService {

    @Autowired
    private TranslateRepository translateRepository;

    @Override
    public String translateWords(String words) {
        return translateRepository.translateWords(words);
    }
}
