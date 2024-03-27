package com.katsadourose.todo.api.ejb.ejb;

import com.katsadourose.todo.api.ejb.dao.TodoItemDao;
import com.katsadourose.todo.api.ejb.dto.PageDto;
import com.katsadourose.todo.api.ejb.entity.TodoItem;
import jakarta.ejb.Stateless;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;

@Stateless
@AllArgsConstructor
public class TodoItemsServiceImpl implements TodoItemsService{

    private final TodoItemDao todoItemDao;

    @Override
    @Transactional
    public TodoItem createItem() {
        return null;
    }

    @Override
    public PageDto<TodoItem> getTodoItemsByUser(String username) {
        return null;
    }

    @Override
    public PageDto<TodoItem> getTodoItems() {
        return null;
    }

    @Override
    public void completeTodoItem(String todoItemId) {

    }

    @Override
    public void deleteTodoItem(String todoItemId) {

    }
}
