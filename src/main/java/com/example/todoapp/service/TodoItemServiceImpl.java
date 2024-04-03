package com.example.todoapp.service;

import com.example.todoapp.model.TodoItem;
import com.example.todoapp.repository.TodoItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class TodoItemServiceImpl implements TodoItemService {

    private final TodoItemRepository todoItemRepository;

    @Autowired
    public TodoItemServiceImpl(TodoItemRepository todoItemRepository) {
        this.todoItemRepository = todoItemRepository;
    }

    @Override
    public TodoItem saveTodoItem(TodoItem todoItem) {
        todoItemRepository.save(todoItem);
        return todoItem;
    }

    @Override
    public List<TodoItem> getAllTodoItems() {
        return todoItemRepository.findAll();
    }

    @Override
    public ResponseEntity<TodoItem> getTodoItemById(Long id) {
        Optional<TodoItem> todoItem = todoItemRepository.findById(id);
        if (todoItem.isPresent()) {
            return ResponseEntity.ok(todoItem.get());
        } else {
            throw new RuntimeException("TodoItem not found for id :: " + id);
        }
    }

    @Override
    public void updateTodoItem(Long id, TodoItem todoItemDetails) {
        todoItemRepository.findById(id).ifPresent(t->{
            t.setTitle(todoItemDetails.getTitle());
            t.setCompleted(todoItemDetails.isCompleted());
            todoItemRepository.save(t);
        });
    }

    @Override
    public void deleteTodoItem(Long id) {
        todoItemRepository.deleteById(id);
    }
}

