package com.spring_crud.Spring_Crud.exceptions;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.http.HttpStatus;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CustomValidationError {
    private Boolean status;
    private  String message;
    private  String type;
    private  Object errors;



}
