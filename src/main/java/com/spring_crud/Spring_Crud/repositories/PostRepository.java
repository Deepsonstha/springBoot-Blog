package com.spring_crud.Spring_Crud.repositories;

import com.spring_crud.Spring_Crud.entities.Category;
import com.spring_crud.Spring_Crud.entities.Post;
import com.spring_crud.Spring_Crud.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PostRepository extends JpaRepository<Post, Integer> {

    List<Post> findByUser(User user);
    List<Post> findByCategory(Category category);

    List<Post> findByTitleContaining(String title);

}
