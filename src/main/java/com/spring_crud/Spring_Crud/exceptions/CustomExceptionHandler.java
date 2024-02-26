package com.spring_crud.Spring_Crud.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.HashMap;
import java.util.Map;

@RestControllerAdvice
public class CustomExceptionHandler {
    @ExceptionHandler(value = {Exception.class})
    public ResponseEntity<Object> handleNotFoundException(NotFoundException notFoundException){
        Map<String, Object> response =new HashMap<>();
        response.put("message", notFoundException.getMessage());
        response.put("status", false);
        return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
    }


    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<Object> handleArgumentNotValidException(MethodArgumentNotValidException ex) {
        Map<String, Object> response = new HashMap<>();

        ex.getBindingResult().getFieldErrors().forEach(error -> {
            response.put(error.getField(), error.getDefaultMessage());
        });

        CustomValidationError validationError = new CustomValidationError(
                false,
                "Invalid form data",
                "validation",
                response
        );
        return new ResponseEntity<>( validationError, HttpStatus.BAD_REQUEST);
    }


}
