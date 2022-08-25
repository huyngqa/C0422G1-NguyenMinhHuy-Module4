package com.example.annotation;

import com.example.annotation.impl.NameValidator;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

@Target({ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = NameValidator.class)
@Documented
public @interface Name {
    String message() default "Tên chỉ chứa chữ và dấu cách.";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
