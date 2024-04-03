package com.example.todoapp.controller;

import com.example.todoapp.model.TodoItem;
import com.example.todoapp.service.TodoItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/todoitems")
public class TodoItemController {
/*
1. 프로젝트 구동환경 확인 : 자바 버전, 라이브러리 등
2. 디비 생성 및 연결 확인!!


쿼리 표준 ( ANSI )

디비 : dialect : 종류별 쿼리 및 디비전용 함수를 지원함


1. user
 - join
 - login
 - update info
 - withdraw

2. todolist by user
 - pagination

3. cli ----- Commend Line ( Native JAVA , Spring X, Gradle X , Maven X )



깃에 기록 남기는 순서

모든 프로젝트에 깃을통한 버전관리 하기!!

1. 프로젝트 만든후에 제일 처음으로 할것은 깃 초기화!!!
 - git init

2. 깃헙 레파지토리 생성 = URL
 - Generate Access Token - Token

3. 프로젝트 최초 커밋하기
 - git add .
 - git commit -m "first commit"

4. 깃 리모트 레파지토리 설정
 - git remote add origin https://[Token]@[URL]
 - git push origin main

5. 기능 단위로 커밋
6. 막히거나 테스트를위해서 분기처리가 필요할때 브랜치 생성
7. 개발용 브랜치를 생성후 개발하고 완성되면 메인브랜치에 병합!!

브랜치 생성 > 개발 > 메인으로 병합
 */
    private final TodoItemService todoItemService;

    @Autowired
    public TodoItemController(TodoItemService todoItemService) {
        this.todoItemService = todoItemService;
    }

    @PostMapping()
    public TodoItem createTodoItem(@RequestBody TodoItem todoItem) {
        return todoItemService.saveTodoItem(todoItem);
    }

    @GetMapping()
    public List<TodoItem> getAllTodoItems() {
        return todoItemService.getAllTodoItems();
    }

    @GetMapping("/{id}")
    public ResponseEntity<TodoItem> getTodoItemById(@PathVariable Long id) {
        return todoItemService.getTodoItemById(id);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Void> updateTodoItem(@PathVariable Long id, @RequestBody TodoItem todoItemDetails) {
        todoItemService.updateTodoItem(id, todoItemDetails);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteTodoItem(@PathVariable Long id) {
        todoItemService.deleteTodoItem(id);
        return ResponseEntity.ok().build();
    }
}

