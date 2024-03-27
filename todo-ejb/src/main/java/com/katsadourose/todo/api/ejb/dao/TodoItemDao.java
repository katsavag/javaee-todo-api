package com.katsadourose.todo.api.ejb.dao;

import com.katsadourose.todo.api.ejb.dto.PageDto;
import com.katsadourose.todo.api.ejb.entity.TodoItem;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Root;
import jakarta.transaction.Transactional;

import java.util.List;

@ApplicationScoped
@Transactional(Transactional.TxType.SUPPORTS)
public class TodoItemDao {

    @PersistenceContext
    private EntityManager entityManager;

    private final CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();

    protected TodoItem findById(long id) {

        return entityManager.find(TodoItem.class, id);
    }

    public PageDto<TodoItem> findAllByPage(int page, int pageSize) {
        CriteriaQuery<TodoItem> cq = criteriaBuilder.createQuery(TodoItem.class);
        CriteriaQuery<Long> countQuery = criteriaBuilder.createQuery(Long.class);
        Root<TodoItem> todoItemRoot = cq.from(TodoItem.class);
        CriteriaQuery<TodoItem> select = cq.select(todoItemRoot);
        CriteriaQuery<Long> count = countQuery.select(criteriaBuilder.count(todoItemRoot));
        Long totalRows = entityManager.createQuery(count).getSingleResult();

        TypedQuery<TodoItem> query = entityManager.createQuery(select);
        query.setFirstResult(page);
        query.setMaxResults(pageSize);
        List<TodoItem> items = query.getResultList();

        return new PageDto<>(
                page,
                pageSize,
                totalRows,
                items
        );
    }


}
