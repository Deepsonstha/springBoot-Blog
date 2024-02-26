package com.spring_crud.Spring_Crud.payloads;

import com.spring_crud.Spring_Crud.entities.Post;
import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Setter
@Getter
@NoArgsConstructor
public class CategoryDTO {

    private  int id;

    @NotBlank(message = "Category Title is required")
    private  String categoryTitle;

    @NotBlank(message = "Category Description is required")
    private  String categoryDescription;

}
