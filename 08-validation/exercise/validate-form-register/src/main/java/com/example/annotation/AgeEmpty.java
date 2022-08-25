package com.example.annotation;

import com.example.annotation.impl.AgeEmptyValidator;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

@Target({ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = AgeEmptyValidator.class)
@Documented
public @interface AgeEmpty {
    String message() default "Vui lòng nhập đúng định dạng ngày tháng năm sinh";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
