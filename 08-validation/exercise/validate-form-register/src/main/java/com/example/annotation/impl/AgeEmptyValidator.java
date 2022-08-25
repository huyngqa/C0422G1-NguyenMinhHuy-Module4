package com.example.annotation.impl;

import com.example.annotation.AgeEmpty;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.time.LocalDate;

public class AgeEmptyValidator implements ConstraintValidator<AgeEmpty, String> {
    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        try {
            LocalDate.parse(value);
        } catch (Exception exception) {
            return false;
        }
        return true;
    }
}
