package com.katsadourose.todo.api.ejb.ejb;

import com.katsadourose.todo.api.ejb.dto.PageDto;
import com.katsadourose.todo.api.ejb.entity.TodoItem;

public interface TodoItemsService {

    TodoItem createItem();
    PageDto<TodoItem> getTodoItemsByUser(String username);
    PageDto<TodoItem> getTodoItems();
    void completeTodoItem(String todoItemId);
    void deleteTodoItem(String todoItemId);
}
