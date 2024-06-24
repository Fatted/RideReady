package com.example.rrclientmodelresourceserver.validation.customvalidator;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class CodiceFiscaleValidator implements ConstraintValidator<CodiceFiscale, String> {
    @Override
    public void initialize(CodiceFiscale codiceFiscale) {
    }

    @Override
    public boolean isValid(String codiceFiscale, ConstraintValidatorContext context) {
        String pattern = "^[A-Z]{6}\\d{2}[A-Z]\\d{2}[A-Z]\\d{3}[A-Z]$";
        return codiceFiscale != null && codiceFiscale.matches(pattern);
    }
}

