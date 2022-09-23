package com.example.backend.Service;

import com.example.backend.Elements.TodoElement;
import com.example.backend.Repository.TodoRepo;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

class TodoServiceTest {

    TodoRepo repo = mock(TodoRepo.class);
    TodoService service = new TodoService(repo);
    @Test
    void getAllTodoElementReturnsListOfTodoElements() {
        //GIVEN
        when(repo.getAllElements()).thenReturn(List.of(new TodoElement(1,"hello","test"),new TodoElement(2,"test2","wtf")));
        //WHEN
        List<TodoElement> actual = service.getAllTodoElement();
        //THEN
        List<TodoElement> expected = List.of(new TodoElement(1,"hello","test"),new TodoElement(2,"test2","wtf"));
        assertEquals(expected,actual);
    }

    @Test
    void postNewElementReturnsAddedTodoElement() {
        //GIVEN
        when(repo.postNewElement(new TodoElement(null,"hallo","tschau"))).thenReturn(new TodoElement(1,"hallo","tschau"));
        //WHEN
        TodoElement actual = service.postNewElement(new TodoElement(null,"hallo","tschau"));
        //THEN
        TodoElement expected = new TodoElement(1,"hallo","tschau");
        assertEquals(expected, actual);
    }

    @Test
    void toChangeReturnsChangedTodoElement() {
        //GIVEN
        when(repo.changeStatus(new TodoElement(1,"hallo","tschau"))).thenReturn(new TodoElement(1,"hallo","hallo"));
        //WHEN
        TodoElement actual = service.toChange(new TodoElement(1,"hallo","tschau"));
        //THEN
        TodoElement expected = new TodoElement(1,"hallo","hallo");
        assertEquals(expected, actual);
    }

    @Test
    void showDetailsReturnsTodoElement() {
        //GIVEN
        when(repo.showDetails("1")).thenReturn(new TodoElement(1,"hallo","hallo"));
        //WHEN
        TodoElement actual = service.showDetails("1");
        //THEN
        TodoElement expected = new TodoElement(1,"hallo","hallo");
        assertEquals(expected, actual);
    }

    @Test
    void deleteElementReturnsDeletedTodoElement() {
        //GIVEN
        when(repo.deleteElement("1")).thenReturn(new TodoElement(1,"hallo","hallo"));
        //WHEN
        TodoElement actual = service.deleteElement("1");
        //THEN
        TodoElement expected = new TodoElement(1,"hallo","hallo");
        assertEquals(expected, actual);
    }

}