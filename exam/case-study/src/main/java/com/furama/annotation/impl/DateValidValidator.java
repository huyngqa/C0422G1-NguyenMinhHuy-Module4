package com.furama.annotation.impl;

import com.furama.annotation.DateValid;
import com.furama.common.ValidDay;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class DateValidValidator implements ConstraintValidator<DateValid, String> {
    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        return ValidDay.isValidDay(value);
    }
}
