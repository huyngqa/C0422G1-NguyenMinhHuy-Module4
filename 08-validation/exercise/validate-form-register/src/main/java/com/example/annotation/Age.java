package com.example.annotation;

import com.example.annotation.impl.AgeValidator;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

@Target({ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = AgeValidator.class)
@Documented
public @interface Age {
    String message() default "Bạn chưa đủ 18 tuổi";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
