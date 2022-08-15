package com.exercise.service.impl;

import com.exercise.service.ConvertService;
import org.springframework.stereotype.Service;

@Service
public class ConvertServiceImpl implements ConvertService {

    @Override
    public double convertCurrency(double money) {
        return money * 23000;
    }
}
