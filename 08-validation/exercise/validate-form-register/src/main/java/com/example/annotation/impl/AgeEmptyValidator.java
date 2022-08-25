package com.example.annotation.impl;

import com.example.annotation.AgeEmpty;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class AgeEmptyValidator implements ConstraintValidator<AgeEmpty, String> {
    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        if(!value.equals("")) {
            return true;
        }
        return false;
    }
}
