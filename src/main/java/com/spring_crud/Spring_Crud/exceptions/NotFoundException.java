package com.spring_crud.Spring_Crud.exceptions;

public class NotFoundException extends  RuntimeException{
    public NotFoundException(String message) {
        super(message);
    }
}
