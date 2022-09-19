package com.example.backend.Repository;

import com.example.backend.Elements.TodoElement;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class TodoRepo {


    private Map<Integer, TodoElement> elements;
    private int id;

    public TodoRepo(List<TodoElement> ListElements) {
        Map<Integer, TodoElement> temp = new HashMap<>();
        for (TodoElement singleElement : ListElements) {
            temp.put(singleElement.getId(), singleElement);
        }
        this.elements = temp;
    }

    public List<TodoElement> getAllElements() {
        return List.copyOf(elements.values());
    }

    public TodoElement postNewElement(TodoElement newElement) {
        newElement.setId(++id);
        elements.put(newElement.getId(), newElement);
        return elements.get(id);

    }

    public TodoElement changeStatus(TodoElement toChange) {
        elements.put(toChange.getId(), toChange);
        return toChange;
    }

    public TodoElement showDetails(String id) {
        return elements.get(Integer.parseInt(id));
    }

    public TodoElement deleteElement(String id) {
        int toDelete = Integer.parseInt(id);
        return elements.remove(toDelete);
    }
}
