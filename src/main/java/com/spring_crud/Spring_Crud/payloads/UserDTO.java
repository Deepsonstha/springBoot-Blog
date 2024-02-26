package com.spring_crud.Spring_Crud.payloads;

import com.spring_crud.Spring_Crud.entities.Post;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@NoArgsConstructor
@Getter
@Setter
public class UserDTO {

    private  int id;

    private  String name;

    @Email(message = "Valid Email is required")
    @NotBlank(message = "Email Field is required")
    private  String email;

    @NotBlank(message = "Password Field is required")
    private  String password;

    @NotBlank(message = "About Field is required")
    private  String about;

}
