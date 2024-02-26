package com.spring_crud.Spring_Crud.controllers;

import com.spring_crud.Spring_Crud.payloads.CategoryDTO;
import com.spring_crud.Spring_Crud.response.ResponseHandler;
import com.spring_crud.Spring_Crud.services.CategoryService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class CategoryController {


    @Autowired
    private CategoryService service;

    @PostMapping("/category")
    public ResponseEntity<Object> createCategory(@Valid @RequestBody CategoryDTO categoryDTO){
        return ResponseHandler.responseBuilder(
                "Successfully create Category",
                true,
                service.createCategory(categoryDTO)
        );
    }

    @PutMapping("/category/{id}")
    public ResponseEntity<Object> updateCategory(@Valid @RequestBody CategoryDTO categoryDTO , @PathVariable("id") Integer categoryId ){
        return ResponseHandler.responseBuilder(
                "Successfully create Category",
                true,
                service.updateCategory(categoryDTO,categoryId)
        );
    }


    @GetMapping("/category")
    public  ResponseEntity<Object> getAllCategory(){
        return ResponseHandler.responseBuilder(
                "Successfully get all Category",
                true,
                service.getAllCategory()
        );
    }

    @GetMapping("/category/{id}")
    public  ResponseEntity<Object> getCategory(@PathVariable("id") Integer categoryId){
        return ResponseHandler.responseBuilder(
                "Successfully get all Category",
                true,
                service.getCategory(categoryId)
        );
    }

    @DeleteMapping("/category/{id}")
    public  ResponseEntity<Object> deleteCategory(@PathVariable("id") Integer categoryId){
        service.deleteCategory(categoryId);
        return ResponseHandler.responseBuilderWithoutData(
                "Successfully get  Category",
                true

        );
    }



}
