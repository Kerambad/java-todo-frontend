package com.example.backend.Controller;

import com.example.backend.Elements.TodoElement;
import com.example.backend.Service.TodoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

import static java.util.List.of;

@RestController
@RequestMapping("api/todo")
public class Controller {

    private final TodoService service;

    @Autowired
    public Controller(TodoService service) {
        this.service = service;
    }

    @GetMapping
    public List<TodoElement> getAllTodoElement() {
        return service.getAllTodoElement();

    }
    @PostMapping
    public void requestElement(@RequestBody TodoElement element) {
        service.postNewElement(element);
    }

    @PutMapping("{id}")
    public void changeStatus(@RequestBody TodoElement element) {
        service.toChange(element);
    }

    @GetMapping("{id}")
    public TodoElement showDetails(@PathVariable String id) {
        return service.showDetails(id);
    }
    @DeleteMapping("{id}")
    public void deleteElement(@PathVariable String id) {
        service.deleteElement(id);
    }
}
