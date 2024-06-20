package com.example.rrclientmodelresourceserver.validation;

import jakarta.validation.ConstraintViolation;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import jakarta.validation.ConstraintViolationException;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@RestControllerAdvice
public class GlobalExceptionHandler {

    private static final Logger logger = LoggerFactory.getLogger(GlobalExceptionHandler.class);

    //metodo per gestire le eccezioni di tipo MethodArgumentNotValidException
    @ExceptionHandler(MethodArgumentNotValidException.class) //annotazione per gestire le eccezioni di tipo MethodArgumentNotValidException
    @ResponseStatus(HttpStatus.BAD_REQUEST) //setto lo status della response a 400
    public ResponseEntity<Map<String, String>> handleValidationExceptions(MethodArgumentNotValidException ex) {
        Map<String, String> errors = new HashMap<>(); //creo una mappa per gli errori
        ex.getBindingResult().getAllErrors().forEach(error -> { //per ogni errore presente nella lista di errori della binding result dell'eccezione passata come parametro
            String fieldName = ((FieldError) error).getField(); //prendo il nome del campo
            String errorMessage = error.getDefaultMessage(); //prendo il messaggio di errore
            errors.put(fieldName, errorMessage); //aggiungo alla mappa il campo e il messaggio di errore
        });
        return new ResponseEntity<>(errors, HttpStatus.BAD_REQUEST); //ritorno la mappa con lo status della response
    }

    //metodo per gestire le eccezioni di tipo ConstraintViolationException
    @ExceptionHandler(ConstraintViolationException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST) //setto lo status della response a 400
    public ResponseEntity<Map<String, String>> handleConstraintViolationException(ConstraintViolationException ex) {
        Map<String, String> errorMessages = ex.getConstraintViolations().stream() //creo una mappa per gli errori
                .collect(Collectors.toMap( //per ogni violazione presente nella lista di violazioni dell'eccezione passata come parametro
                        violation -> violation.getPropertyPath().toString(), //prendo il nome del campo
                        ConstraintViolation::getMessage, //prendo il messaggio di errore
                        (oldValue, newValue) -> oldValue + newValue //se il campo è già presente nella mappa aggiungo il nuovo messaggio di errore
                ));
        return new ResponseEntity<>(errorMessages, HttpStatus.BAD_REQUEST); //ritorno la mappa con lo status della response
    }

    //metodo per gestire le eccezioni di tipo ResourceNotFoundException
    @ExceptionHandler(ResourceNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND) //setto lo status della response a 404
    public ResponseEntity<Map<String, String>> handleResourceNotFoundException(ResourceNotFoundException ex) {
        Map<String, String> error = new HashMap<>(); //creo una mappa per l'errore
        error.put("error", "Resource Not Found"); //setto il tipo di errore
        error.put("message", ex.getMessage()); //setto il messaggio di errore
        return new ResponseEntity<>(error, HttpStatus.NOT_FOUND); //ritorno la mappa con lo status della response
    }

    //metodo per gestire le eccezioni di tipo IllegalArgumentException
    @ExceptionHandler(IllegalArgumentException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST) //setto lo status della response a 400
    public ResponseEntity<Map<String, String>> handleIllegalArgumentException(IllegalArgumentException ex) {
        Map<String, String> error = new HashMap<>(); //creo una mappa per l'errore
        error.put("error", "Bad Request"); //setto il tipo di errore
        error.put("message", ex.getMessage()); //setto il messaggio di errore
        return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST); //ritorno la mappa con lo status della response
    }

    @ExceptionHandler(Exception.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR) //setto lo status della response a 500
    public ResponseEntity<Map<String, String>> handleAllExceptions(Exception ex) {
        Map<String, String> error = new HashMap<>(); //creo una mappa per l'errore
        error.put("error", "Internal Server Error"); //setto il tipo di errore
        error.put("message", ex.getMessage()); //setto il messaggio di errore
        return new ResponseEntity<>(error, HttpStatus.INTERNAL_SERVER_ERROR); //ritorno la mappa con lo status della response
    }
}