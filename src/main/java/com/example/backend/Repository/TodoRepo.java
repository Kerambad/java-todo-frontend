package com.example.backend.Repository;

import com.example.backend.Elements.TodoElement;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class TodoRepo {


    private Map<Integer,TodoElement> elements;

    public TodoRepo(List<TodoElement> ListElements) {
        for (TodoElement singleElement : ListElements){
            elements.put(singleElement.getId(),singleElement);
        }
    }

    public List<TodoElement> getAllElements() {
        return List.copyOf(elements.values());
    }

    public void postNewElement(List<TodoElement> newElement) {
        for (TodoElement curentElement : newElement) {
            elements.put(curentElement.getId(), curentElement);
        }
    }
}
