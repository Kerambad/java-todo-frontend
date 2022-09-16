package com.example.backend.Service;

import com.example.backend.Elements.TodoElement;
import com.example.backend.Repository.TodoRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TodoService {
    private TodoRepo repo;

    public TodoService(TodoRepo repo) {
        this.repo = repo;
    }

    public List<TodoElement> getAllTodoElement() {
        return repo.getAllElements();
    }

    public void postNewElement(List<TodoElement> newElement) {
        repo.postNewElement(newElement);
    }

}
