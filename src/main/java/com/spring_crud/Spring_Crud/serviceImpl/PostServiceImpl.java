package com.spring_crud.Spring_Crud.serviceImpl;


import com.spring_crud.Spring_Crud.entities.Category;
import com.spring_crud.Spring_Crud.entities.Post;
import com.spring_crud.Spring_Crud.entities.User;
import com.spring_crud.Spring_Crud.exceptions.NotFoundException;
import com.spring_crud.Spring_Crud.payloads.PostDTO;
import com.spring_crud.Spring_Crud.payloads.PostPaginationResponse;
import com.spring_crud.Spring_Crud.repositories.CategoryRepository;
import com.spring_crud.Spring_Crud.repositories.PostRepository;
import com.spring_crud.Spring_Crud.repositories.UserRepository;
import com.spring_crud.Spring_Crud.services.PostService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class PostServiceImpl implements PostService {

    @Autowired
    private PostRepository repository;

    @Autowired
    ModelMapper modelMapper;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private CategoryRepository categoryRepository;


    PostDTO postToDTO(Post post){
        return  modelMapper.map(post ,PostDTO.class);
    }

    Post dTOtoPost(PostDTO postDTO){
        return  modelMapper.map(postDTO , Post.class);
    }



    @Override
    public PostDTO createPost(PostDTO postDTO, Integer userId, Integer categoryId) {

        User foundUser = this.userRepository.findById(userId).orElseThrow(() ->new NotFoundException("User Not Found"));
        Category foundCategory = this.categoryRepository.findById(categoryId).orElseThrow(() -> new NotFoundException("Category Id Not found"));

       Post post =   dTOtoPost(postDTO);

       post.setTitle(post.getTitle());
       post.setDescription(post.getDescription());
       post.setImageName("default.png");
       post.setUser(foundUser);
       post.setCategory(foundCategory);

       Post newpost = this.repository.save(post);
        return postToDTO(newpost);
    }

    @Override
    public PostDTO updatePost(PostDTO postDTO, Integer postId) {
        Post foundPost =  repository.findById(postId).orElseThrow(() -> new NotFoundException("Post not found"));

        foundPost.setTitle(postDTO.getTitle());
        foundPost.setDescription(postDTO.getDescription());
        foundPost.setImageName(postDTO.getImageName());

        Post savePost =  this.repository.save(foundPost);
        return postToDTO(savePost);
    }

    @Override
    public void deletePost(Integer postId) {
        Post foundPost =  repository.findById(postId).orElseThrow(() -> new NotFoundException("Post not found"));
        this.repository.delete(foundPost);
    }

    @Override
    public PostPaginationResponse getAllPost(Integer pageNumber, Integer pageSize, String sortBy) {

        Pageable pageable = PageRequest.of(pageNumber,pageSize, Sort.by(sortBy).descending());
//        Pageable pageable = PageRequest.of(pageNumber, pageSize);
            Page<Post> pagePost =  this.repository.findAll(pageable);
            List<Post> allPosts =  pagePost.getContent();
         List<PostDTO>   listpostDto = allPosts.stream().map(post ->postToDTO(post) ).collect(Collectors.toList());
           PostPaginationResponse postPaginationResponse = new  PostPaginationResponse();

           postPaginationResponse.setData(listpostDto);
           postPaginationResponse.setPageNumber(pagePost.getNumber());
           postPaginationResponse.setPageSize(pagePost.getSize());
           postPaginationResponse.setTotalElements(pagePost.getTotalElements());
           postPaginationResponse.setTotalPages(pagePost.getTotalPages());
           postPaginationResponse.setLastPage(pagePost.isLast());
           return  postPaginationResponse;
    }

    @Override
    public PostDTO getPost(Integer postId) {
        Post post = this.repository.findById(postId).orElseThrow(() -> new NotFoundException("Post not found"));
        return postToDTO(post);
    }

    @Override
    public List<PostDTO> getPostByCategory(Integer categoryId) {
        Category category  = this.categoryRepository.findById(categoryId).orElseThrow(() -> new NotFoundException("Category not found"));
        List<Post> posts = this.repository.findByCategory(category);
        return posts.stream().map(post -> postToDTO(post)).collect(Collectors.toList());
    }

    @Override
    public List<PostDTO> getPostByUser(Integer userId) {
        return null;
    }

    @Override
    public List<PostDTO> searchPosts(String query) {
        List<Post> posts = this.repository.findByTitleContaining(query);
        List<PostDTO> postsDto = posts.stream().map( post -> postToDTO(post)).collect(Collectors.toList());
        return postsDto ;
    }




}
