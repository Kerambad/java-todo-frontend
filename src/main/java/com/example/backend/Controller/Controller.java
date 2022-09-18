package com.example.backend.Controller;

import com.example.backend.Elements.TodoElement;
import com.example.backend.Service.TodoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.view.RedirectView;

import java.net.http.HttpClient;
import java.util.List;

//TODO: make Links reloading working
@RestController
@RequestMapping(path = {"api/todo","details/","edit/"})
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
    public TodoElement requestElement(@RequestBody TodoElement element) {
        return service.postNewElement(element);
    }

    @PutMapping("{id}")
    public TodoElement changeStatus(@RequestBody TodoElement element) {
        return service.toChange(element);
    }

    @GetMapping("{id}")
    public TodoElement showDetails(@PathVariable String id) {
        return service.showDetails(id);
    }
    @DeleteMapping("{id}")
    public TodoElement deleteElement(@PathVariable String id) {
        return service.deleteElement(id);
    }
}
