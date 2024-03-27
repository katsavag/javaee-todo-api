package com.katsadourose.todo.api.ejb.entity;

import jakarta.persistence.*;

import java.util.Set;

@Entity
@Table(name = "CATEGORIES")
@NamedQuery(name = Category.FIND_ALL, query = "select c from Category c")
public class Category {

    public static final String FIND_ALL = "Category.findAll";

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
