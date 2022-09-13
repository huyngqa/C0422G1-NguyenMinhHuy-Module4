package com.furama.annotation;

import com.furama.annotation.impl.DateValidValidator;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

@Target({ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = DateValidValidator.class)
@Documented
public @interface DateValid {
    String message() default "Date time format error";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};

}
