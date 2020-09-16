package com.example.todo.controllers;

import com.example.todo.model.Todo;
import com.example.todo.services.TodoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin(origins = "*")
public class TodoRestController {

    @Autowired
    TodoService todoService;

    @PostMapping("/todo")
    Todo save(@RequestBody Todo todo) throws Exception {
        return todoService.save(todo);
    }


    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public List<FieldError> exceptionHandler(MethodArgumentNotValidException ex) {
        BindingResult result = ex.getBindingResult();
        return result.getFieldErrors();
    }

    @GetMapping("/todo")
    Iterable<Todo> findAll() {
        return todoService.findAll();
    }

    @DeleteMapping("/todo/{id}")
    void delete(@PathVariable int id){
        todoService.deleteById(id);
    }

}
