package com.spring_crud.Spring_Crud.services;

import com.spring_crud.Spring_Crud.payloads.CategoryDTO;

import java.util.List;

public interface CategoryService {
    CategoryDTO createCategory(CategoryDTO categoryDTO);
    CategoryDTO updateCategory(CategoryDTO categoryDTO, Integer categoryId);
    List<CategoryDTO> getAllCategory();
    CategoryDTO getCategory(Integer categoryId);

    void deleteCategory(Integer categoryId);

}
