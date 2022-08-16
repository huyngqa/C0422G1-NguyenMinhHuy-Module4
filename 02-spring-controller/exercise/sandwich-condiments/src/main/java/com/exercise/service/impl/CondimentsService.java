package com.exercise.service.impl;

import com.exercise.repository.ICondimentsRepository;
import com.exercise.service.ICondimentsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CondimentsService implements ICondimentsService {

    @Autowired
    private ICondimentsRepository iCondimentsRepository;

    @Override
    public List<String> getAllCondiments() {
        return iCondimentsRepository.getAllCondiments();
    }
}
