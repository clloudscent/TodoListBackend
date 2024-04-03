package com.example.todoapp.service;

import com.example.todoapp.model.TodoItem;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface TodoItemService {
    TodoItem saveTodoItem(TodoItem todoItem);

    List<TodoItem> getAllTodoItems();

    ResponseEntity<TodoItem> getTodoItemById(Long id);

    void updateTodoItem(Long id, TodoItem todoItem);

    void deleteTodoItem(Long id);
}
