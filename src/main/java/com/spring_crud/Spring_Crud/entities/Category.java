package com.spring_crud.Spring_Crud.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Category {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  Integer id;

    private  String categoryTitle;

    private  String categoryDescription;

    @OneToMany(mappedBy = "category",cascade = CascadeType.ALL)
    private List<Post> posts;

}
