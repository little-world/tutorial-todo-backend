package com.example.todo.controllers;


import com.example.todo.model.Todo;
import com.example.todo.services.TodoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = "*")
public class TodoWsController {

    @Autowired
    TodoService todoService;

    @MessageMapping("/add")
    @SendTo("/topic/add")
    public Todo save(Todo todo) throws Exception {
        return todoService.save(todo);
    }

    @MessageMapping("/delete")
    @SendTo("/topic/delete")
    public Integer delete(Integer id) throws Exception {
        todoService.deleteById(id);
        return id;
    }

}
