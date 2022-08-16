package com.exercise.service.impl;

import com.exercise.repository.CondimentsRepository;
import com.exercise.service.CondimentsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CondimentsServiceImpl implements CondimentsService {

    @Autowired
    private CondimentsRepository condimentsRepository;

    @Override
    public List<String> getAllCondiments() {
        return condimentsRepository.getAllCondiments();
    }
}
