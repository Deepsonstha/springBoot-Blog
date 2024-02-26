package com.spring_crud.Spring_Crud.response;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.lang.Nullable;

import java.util.HashMap;
import java.util.Map;

public class ResponseHandler {
    public  static ResponseEntity<Object> responseBuilder(

            String message,
            boolean status,
            Object responseObject
    ){
        Map<String , Object> response = new HashMap<>();
        response.put("status", true);
        response.put("message", message);
        response.put("data", responseObject);

        return new   ResponseEntity<>(response, HttpStatus.OK);
    }

    public  static ResponseEntity<Object> responseBuilderWithoutData(
            String message,
            boolean status
    ){
        Map<String , Object> response = new HashMap<>();
        response.put("status", true);
        response.put("message", message);

        return new   ResponseEntity<>(response, HttpStatus.OK);
    }




}
