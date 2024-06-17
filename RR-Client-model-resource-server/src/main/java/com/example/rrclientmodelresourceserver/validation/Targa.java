package com.example.rrclientmodelresourceserver.validation;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Constraint(validatedBy = TargaValidator.class)
@Target({ElementType.FIELD, ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
public @interface Targa {
    String message() default "La targa non rispetta il formato NN-000-NN";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
