package com.example.todo.controllers;

import com.example.todo.model.Todo;
import com.example.todo.services.TodoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "*")
public class TodoRestController {

    @Autowired
    TodoService todoService;

    @PostMapping("/todo")
    Todo save(@RequestBody Todo todo) {
        return todoService.save(todo);
    }

    @GetMapping("/todo")
    Iterable<Todo> findAll() {
        return todoService.findAll();
    }

    @DeleteMapping("/todo/{id}")
    void delete(@PathVariable int id) {
        todoService.deleteById(id);
    }

}
