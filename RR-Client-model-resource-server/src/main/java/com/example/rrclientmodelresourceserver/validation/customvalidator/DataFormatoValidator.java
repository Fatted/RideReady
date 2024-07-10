package com.example.rrclientmodelresourceserver.validation.customvalidator;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

public class DataFormatoValidator implements ConstraintValidator<DataFormato, LocalDate> {

    private static final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");

    @Override
    public void initialize(DataFormato constraintAnnotation) {
    }

    @Override
    public boolean isValid(LocalDate value, ConstraintValidatorContext context) {
        if (value == null) {
            return false;
        }

        try {
            // Formatta la LocalDate in una stringa nel formato desiderato
            String formattedDate = value.format(formatter);

            // Verifica che la stringa formattata corrisponda al formato desiderato
            if (!formattedDate.matches("\\d{2}/\\d{2}/\\d{4}")) {
                throw new DateTimeParseException("La data non è nel formato dd/MM/yyyy", formattedDate, 0);
            }

            // Se tutto è corretto, ritorna true
            return true;

        } catch (DateTimeParseException e) {
            throw new IllegalArgumentException("La data deve essere nel formato dd/MM/yyyy", e);
        }
    }
}
