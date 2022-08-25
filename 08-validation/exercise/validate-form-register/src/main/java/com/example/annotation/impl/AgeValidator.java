package com.example.annotation.impl;

import com.example.annotation.Age;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.time.LocalDate;
import java.time.Period;

public class AgeValidator implements ConstraintValidator<Age, String> {
    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        if(value.equals("")) {
            return true;
        }
        int checkAge = Period.between(LocalDate.parse(value), LocalDate.now()).getYears();
        return checkAge >=18;
    }
}
