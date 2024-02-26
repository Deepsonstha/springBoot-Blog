package com.spring_crud.Spring_Crud.entities;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Setter
@Getter
@ToString
@NoArgsConstructor
public class Post {
    @Id
    @GeneratedValue
    private  Integer id;

    private  String title;


    private  String description;


    private  String imageName;


    @ManyToOne
    @JoinColumn(name = "category_id")
    private  Category category;


    @ManyToOne
    @JoinColumn(name = "user_id")
    private  User user;


}
