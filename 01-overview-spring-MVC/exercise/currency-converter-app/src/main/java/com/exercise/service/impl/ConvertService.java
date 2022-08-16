package com.exercise.service.impl;

import com.exercise.service.IConvertService;
import org.springframework.stereotype.Service;

@Service
public class ConvertService implements IConvertService {

    @Override
    public double convertCurrency(double money) {
        return money * 23000;
    }
}
