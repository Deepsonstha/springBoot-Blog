package com.spring_crud.Spring_Crud.serviceImpl;

import com.spring_crud.Spring_Crud.entities.Category;
import com.spring_crud.Spring_Crud.entities.User;
import com.spring_crud.Spring_Crud.exceptions.NotFoundException;
import com.spring_crud.Spring_Crud.payloads.CategoryDTO;
import com.spring_crud.Spring_Crud.payloads.UserDTO;
import com.spring_crud.Spring_Crud.repositories.CategoryRepository;
import com.spring_crud.Spring_Crud.services.CategoryService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CategoryServiceImpl  implements CategoryService {

    @Autowired
    private CategoryRepository repository;
    @Autowired
    private ModelMapper modelMapper;


    @Override
    public CategoryDTO createCategory(CategoryDTO categoryDTO) {
        Category category = dtoToCategory(categoryDTO);
        Category addCat = repository.save(category);
        return categoryToDTo(addCat);
    }

    @Override
    public CategoryDTO updateCategory(CategoryDTO categoryDTO, Integer categoryId) {
        Category foundCategory = repository.findById(categoryId).orElseThrow(() -> new NotFoundException("User Not Found"));
        foundCategory.setCategoryTitle(categoryDTO.getCategoryTitle());
        foundCategory.setCategoryDescription(categoryDTO.getCategoryDescription());
        Category saveCategory =  this.repository.save(foundCategory);
        return categoryToDTo(foundCategory);
    }

    @Override
    public List<CategoryDTO> getAllCategory() {
        List<Category> foundCategory = this.repository.findAll();
        return  foundCategory.stream().map(category -> this.categoryToDTo(category)).collect(Collectors.toList());

    }

    @Override
    public CategoryDTO getCategory(Integer categoryId) {
        Category foundCategory = this.repository.findById(categoryId).orElseThrow(() -> new NotFoundException("Category Not Found"));
        return categoryToDTo(foundCategory);
    }

    @Override
    public void deleteCategory(Integer categoryId) {
        Category foundCategory = this.repository.findById(categoryId).orElseThrow(() -> new NotFoundException("Category Not Found"));
         this.repository.delete(foundCategory);
    }

    private Category dtoToCategory(CategoryDTO categoryDTO){
        return this.modelMapper.map(categoryDTO, Category.class);
    }

    private CategoryDTO categoryToDTo(Category category){
        return this.modelMapper.map(category, CategoryDTO.class);

    }
}
