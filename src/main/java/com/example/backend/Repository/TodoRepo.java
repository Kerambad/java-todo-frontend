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
        Map<Integer,TodoElement> temp = new HashMap<>();
        for (TodoElement singleElement : ListElements){
            elements.put(singleElement.getId(),singleElement);
        }
        this.elements = temp;
    }

    public List<TodoElement> getAllElements() {
        return List.copyOf(elements.values());
    }

    public void postNewElement(TodoElement newElement) {
        newElement.setId(elements.size() + 1);
        elements.put(newElement.getId(),newElement);
    }
    public void changeStatus(TodoElement toChange) {
        elements.put(toChange.getId(),toChange);
    }
    public List<TodoElement> showDetails(String id) {
        return List.of(elements.get(Integer.parseInt(id)));
    }


}
