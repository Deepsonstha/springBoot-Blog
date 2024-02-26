package com.spring_crud.Spring_Crud.controllers;

import com.spring_crud.Spring_Crud.payloads.PostDTO;
import com.spring_crud.Spring_Crud.response.ResponseHandler;
import com.spring_crud.Spring_Crud.serviceImpl.PostServiceImpl;
import com.spring_crud.Spring_Crud.services.PostService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class PostController {

    @Autowired
    private PostService service;


    @PostMapping("/user/{userId}/category/{categoryId}/post")
    ResponseEntity<Object> createPost(
            @Valid @RequestBody PostDTO postDTO,
              @PathVariable("userId") Integer userId,
              @PathVariable("categoryId") Integer categoryId
    ){
        return ResponseHandler.responseBuilder(
                "Successfully create post",
                true,
                service.createPost(postDTO, userId, categoryId)
        );
    }


    @GetMapping("/post")
    ResponseEntity<Object> getAllPost(
            @RequestParam(value = "pageNumber", defaultValue = "0",required = false) Integer pageNumber,
            @RequestParam(value = "pageSize", defaultValue = "10",required = false) Integer pageSize,
            @RequestParam(value = "sortBy", defaultValue = "id", required = false) String sortBy
    ){
        return  ResponseHandler.responseBuilder(
                "Successfully get all post",
                true,
                service.getAllPost(
                        pageNumber,
                        pageSize,
                        sortBy
                )
        );
    }


    @GetMapping("/post/category/{categoryId}")
    ResponseEntity<Object> getPostByCategory( @PathVariable("categoryId") Integer categoryId ){
        return ResponseHandler.responseBuilder(
                "Successfully  get category with post",
                true,
                service.getPostByCategory(categoryId)
        );
    }

    @PutMapping("/post/{postId}")
    ResponseEntity<Object> updatePost(@PathVariable("postId") Integer postId,@RequestBody PostDTO postDTO){
        System.out.println("ggg"+postDTO);
        return ResponseHandler.responseBuilder(
                "Successfully  get category with post",
                true,
                service.updatePost(postDTO, postId)
        );
    }

    @DeleteMapping("/post/{postId}")
    ResponseEntity<Object> deletePost(@PathVariable("postId") Integer postId){
        this.service.deletePost(postId);
        return ResponseHandler.responseBuilderWithoutData(
                "Successfully Deleted Post",
                true
        );
    }


    @GetMapping("/post/search")
    ResponseEntity<Object> searchPosts(@RequestParam(value = "title", defaultValue = "title",required = false) String title){
        return  ResponseHandler.responseBuilder(
                "Successfully  Get search post",
                true,
                this.service.searchPosts(title)


        );
    }

}
