package com.example.rrclientmodelresourceserver.validation.customvalidator;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Constraint(validatedBy = CodiceFiscaleValidator.class)
@Target({ElementType.FIELD, ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
public @interface CodiceFiscale {
    String message() default "Codice Fiscale deve essere di 16 caratteri";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}

