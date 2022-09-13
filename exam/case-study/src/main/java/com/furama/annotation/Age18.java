package com.furama.annotation;

import com.furama.annotation.impl.Age18Validator;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

@Target({ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = Age18Validator.class)
@Documented
public @interface Age18 {
    String message() default "You are not old enough";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
