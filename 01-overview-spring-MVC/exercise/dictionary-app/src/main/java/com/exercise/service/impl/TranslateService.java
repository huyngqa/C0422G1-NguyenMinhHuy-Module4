package com.exercise.service.impl;

import com.exercise.repository.ITranslateRepository;
import com.exercise.service.ITranslateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TranslateService implements ITranslateService {

    @Autowired
    private ITranslateRepository iTranslateRepository;

    @Override
    public String translateWords(String words) {
        return iTranslateRepository.translateWords(words);
    }
}
