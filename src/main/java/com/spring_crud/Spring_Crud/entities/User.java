package com.spring_crud.Spring_Crud.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Entity
//@Table(name = "users")
@NoArgsConstructor
@Getter
@Setter
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private  Integer id;

    private  String name;

    private  String email;

    private  String password;

    private  String about;

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    private List<Post> posts;


}
