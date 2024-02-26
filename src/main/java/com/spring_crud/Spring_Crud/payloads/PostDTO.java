package com.spring_crud.Spring_Crud.payloads;


import com.spring_crud.Spring_Crud.entities.Category;
import com.spring_crud.Spring_Crud.entities.User;
import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@NoArgsConstructor
@Setter
@Getter
@ToString
public class PostDTO {

    private  int id;

    @NotBlank(message = "Title is required")
    private  String title;

    @NotBlank(message = "Description is required")
    private  String description;

    private  String imageName;

    private CategoryDTO category;

    private UserDTO user;

}
