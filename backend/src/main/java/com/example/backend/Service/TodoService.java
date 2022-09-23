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

    public TodoElement postNewElement(TodoElement newElement) {
        return repo.postNewElement(newElement);

    }

    public TodoElement toChange(TodoElement toChange) {
        return repo.changeStatus(toChange);
    }

    public TodoElement showDetails(String id) {
        return repo.showDetails(id);
    }

    public TodoElement deleteElement(String id) {
        return repo.deleteElement(id);
    }
}
