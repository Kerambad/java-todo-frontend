package com.example.backend.Repository;

import com.example.backend.Elements.TodoElement;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class TodoRepoTest {

    @Test
    void getAllElementsShouldReturnListOfTodoElements() {
        //GIVEN
        TodoRepo repo = repoWithElements();
        //WHEN
        List<TodoElement> actual = repo.getAllElements();
        //THEN
        assertEquals(expectedList(), actual);
    }

    @Test
    void postNewElementShouldReturnAddedTodoElement() {
        //GIVEN
        TodoRepo repo = new TodoRepo(new ArrayList<>());
        TodoElement toAdd = new TodoElement(null,"Hello","bye");
        //WHEN
        TodoElement actual = repo.postNewElement(toAdd);
        //THEN
        TodoElement expected = new TodoElement(1,"Hello","bye");
        assertEquals(expected, actual);
    }
    @Test
    void changeStatusShouldReturnUpdatedElement() {
        //GIVEN
        TodoRepo repo = repoWithElements();
        TodoElement toChange = new TodoElement(2,"Hello","bye");
        //WHEN
        TodoElement actual = repo.changeStatus(toChange);
        //THEN
        TodoElement expected = new TodoElement(2,"Hello","bye");
        assertEquals(expected, actual);
    }

    @Test
    void showDetailsShouldReturnTodoElementById() {
        TodoRepo repo = repoWithElements();
        //GIVEN
        String id = "2";
        //WHEN
        TodoElement actual = repo.showDetails(id);
        //THEN
        TodoElement expected = new TodoElement(2,"Was geht","Nix");
        assertEquals(expected, actual);
    }

    @Test
    void deleteElementSholdReturnDeletedTodoElement() {
        TodoRepo repo = repoWithElements();
        //GIVEN
        String id = "2";
        //WHEN
        TodoElement actual = repo.deleteElement(id);
        //THEN
        TodoElement expected = new TodoElement(2,"Was geht","Nix");
        assertEquals(expected, actual);
    }

    private TodoRepo repoWithElements() {
        return new TodoRepo(new ArrayList<>(List.of(new TodoElement(1,"Hello", "Tschau")
                ,new TodoElement(2,"Was geht","Nix")
                ,new TodoElement(3,"So das","wars"))));
    }
    private List<TodoElement> expectedList() {
        return List.of(new TodoElement(1,"Hello", "Tschau")
                ,new TodoElement(2,"Was geht","Nix")
                ,new TodoElement(3,"So das","wars"));
    }
}