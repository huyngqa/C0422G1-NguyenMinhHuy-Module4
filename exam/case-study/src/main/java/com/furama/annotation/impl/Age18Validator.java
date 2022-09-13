package com.furama.annotation.impl;

import com.furama.annotation.Age18;
import com.furama.common.ValidDay;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class Age18Validator implements ConstraintValidator<Age18, String> {

    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        return ValidDay.checkAge18(value);
    }
}
