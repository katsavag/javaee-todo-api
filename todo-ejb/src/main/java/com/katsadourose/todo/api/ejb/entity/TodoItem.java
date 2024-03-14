package com.katsadourose.todo.api.ejb.entity;

import com.katsadourose.todo.api.ejb.enums.PriorityEnum;
import jakarta.persistence.*;
import lombok.Getter;

import java.util.Date;

@Entity
@Table(name = "TodoItems")
@Getter
@NamedQuery(name = TodoItem.FIND_ALL, query = "select t from TodoItem t")
@NamedQuery(name = TodoItem.FIND_BY_COMPLETED, query = "select t from TodoItem t where t.completed = :completed")
public class TodoItem {

    public final static String FIND_ALL = "TodoItem.findAll";
    public final static String FIND_BY_COMPLETED = "TodoItem.findByEnabled";

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "todo-item-sec-generator")
    private long id;

    private String title;

    private String description;

    @Column(name = "due_date")
    private Date dueDate;

    private boolean completed;

    @Enumerated(EnumType.STRING)
    private PriorityEnum priority;

    @ManyToOne
    @JoinColumn(name = "category_id")
    private Category category;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;
}
