package com.katsadourose.todo.api.ejb.entity;

import jakarta.persistence.*;

import java.util.Set;

@Entity
@Table(name = "categories")
public class Category {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String name;

    @Column
    private String description;

    @OneToMany(mappedBy = "category", cascade = CascadeType.ALL)
    private Set<TodoItem> todoItems;
}
