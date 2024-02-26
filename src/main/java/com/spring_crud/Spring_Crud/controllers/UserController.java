package com.spring_crud.Spring_Crud.controllers;

import com.spring_crud.Spring_Crud.payloads.UserDTO;
import com.spring_crud.Spring_Crud.response.ResponseHandler;
import com.spring_crud.Spring_Crud.services.UserService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class UserController {
    @Autowired
    private UserService service;



    @PostMapping("/user")
    public ResponseEntity<Object> createUser(@Valid @RequestBody UserDTO userDTO){
        return ResponseHandler.responseBuilder(
                "Successfully Created User",
               true,
               service.createUser(userDTO)
        );
    }

    @GetMapping("/user")
    public  ResponseEntity<Object> getAllUser(){
       return  ResponseHandler.responseBuilder(
               "Successfully Get All User",
               true,
               service.getUserList()
       );
    }

    @GetMapping("/user/{id}")
    public  ResponseEntity<Object> getUserById(@PathVariable("id") int userId){
        return  ResponseHandler.responseBuilder(
                "Successfully get user",
                true,
                service.getUserById(userId)
        );
    }

    @PutMapping("/user/{id}")
    public ResponseEntity<Object> updateUser(@Valid @PathVariable("id")int userId, @RequestBody UserDTO userDTO){
        return ResponseHandler.responseBuilder(
                "Successfully Created User",
               true,
                service.updateUser(userDTO,userId)
        );
    }


    @DeleteMapping("user/{id}")
    public  ResponseEntity<Object> deleteUser(@PathVariable("id") int userID){

            service.deleteUser(userID);
            return ResponseHandler.responseBuilderWithoutData(
                    "Successfully Deleted User",
                    true
            );
    }

}
