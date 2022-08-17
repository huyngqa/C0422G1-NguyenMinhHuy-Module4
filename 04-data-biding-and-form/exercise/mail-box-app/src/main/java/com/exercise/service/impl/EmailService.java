package com.exercise.service.impl;

import com.exercise.repository.IEmailRepository;
import com.exercise.service.IEmailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmailService implements IEmailService {
    @Autowired
    private IEmailRepository iEmailRepository;

    @Override
    public List<String> findAllLanguages() {
        return iEmailRepository.findAllLanguages();
    }

    @Override
    public List<Integer> findAllPageSize() {
        return iEmailRepository.findAllPageSize();
    }
}
