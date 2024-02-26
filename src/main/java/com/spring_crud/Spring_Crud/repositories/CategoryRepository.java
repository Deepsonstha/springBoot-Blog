package com.spring_crud.Spring_Crud.repositories;

import com.spring_crud.Spring_Crud.entities.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Integer> {

}
