package com.example.rrclientmodelresourceserver.validation;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class TargaValidator implements ConstraintValidator<Targa, String> {
    @Override
    public void initialize(Targa constraintAnnotation) {
        ConstraintValidator.super.initialize(constraintAnnotation);
    }

    @Override
    public boolean isValid(String targa, ConstraintValidatorContext constraintValidatorContext) {
        // Il pattern regex per il formato NN-000-NN
        String pattern = "^[A-Z]{2}-\\d{3}-[A-Z]{2}$";

        // Verifica se la targa corrisponde al pattern
        return targa != null && targa.matches(pattern);
    }
}
