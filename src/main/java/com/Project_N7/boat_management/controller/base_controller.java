package com.Project_N7.boat_management.controller;

import java.util.ArrayList;
import java.util.List;

import com.Project_N7.boat_management.rto.errorRTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;

import com.fasterxml.jackson.core.JsonProcessingException;

@ControllerAdvice
public abstract class base_controller {

    @ExceptionHandler(JsonProcessingException.class)
    public ResponseEntity<Object> handleInvalidJson(JsonProcessingException ex) {
        return new ResponseEntity<>("Si è inserito un testo JSON non valido", HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<Object> handleValidationExceptions(MethodArgumentNotValidException ex) {
        List<errorRTO> errorRtoList = new ArrayList<>();
        ex.getBindingResult().getAllErrors().forEach(error -> {
            String fieldName = ((FieldError) error).getField();
            String errorMessage = error.getDefaultMessage();
            errorRtoList.add(new errorRTO(fieldName, errorMessage));
        });
        return new ResponseEntity<>(errorRtoList, HttpStatus.BAD_REQUEST);
    }


    @ExceptionHandler(MethodArgumentTypeMismatchException.class)
    public ResponseEntity<Object> handleValidationExceptions(MethodArgumentTypeMismatchException ex) {
        List<errorRTO> errorRtoList = new ArrayList<>();
        String fieldName = ex.getName();
        String errorMessage = ex.getMessage();
        errorRtoList.add(new errorRTO(fieldName, errorMessage));

        return new ResponseEntity<>(errorRtoList, HttpStatus.BAD_REQUEST);
    }

}