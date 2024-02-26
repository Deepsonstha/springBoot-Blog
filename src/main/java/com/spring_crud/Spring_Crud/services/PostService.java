package com.spring_crud.Spring_Crud.services;


import com.spring_crud.Spring_Crud.entities.Post;
import com.spring_crud.Spring_Crud.payloads.PostDTO;
import com.spring_crud.Spring_Crud.payloads.PostPaginationResponse;

import java.util.List;

public interface PostService {

    PostDTO createPost(PostDTO postDTO, Integer userId, Integer categoryId);
    PostDTO updatePost(PostDTO postDTO, Integer postId);
    void deletePost(Integer postId);
    PostPaginationResponse getAllPost(Integer pageNumber, Integer pageSize, String sortBy );
    PostDTO getPost(Integer postId);

    //get post by category
    List<PostDTO> getPostByCategory(Integer categoryId);

    // get post by user
    List<PostDTO> getPostByUser(Integer userId);


    // search by post
    List<PostDTO> searchPosts(String query);

}
