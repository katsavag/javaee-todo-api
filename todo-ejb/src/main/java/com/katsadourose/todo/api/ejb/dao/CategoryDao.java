package com.katsadourose.todo.api.ejb.dao;

import com.katsadourose.todo.api.ejb.entity.Category;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;

import java.util.List;

@ApplicationScoped
public class CategoryDao {

    @PersistenceContext
    private EntityManager entityManager;

    public List<Category> findALLCategories() {
        TypedQuery<Category> categoryQuery = entityManager.createNamedQuery(Category.FIND_ALL, Category.class);
        return categoryQuery.getResultList();
    }

    public void persistCategory(Category category) {
        entityManager.persist(category);
    }

}
