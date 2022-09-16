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

    @Test
    void getAllTodoElementReturnsListOfTodoElements() {
        TodoService service = getServiceObject();
        //GIVEN
        when(service.getAllTodoElement()).thenReturn(List.of(new TodoElement(1,"hello","test"),new TodoElement(2,"test2","wtf")));
        //WHEN
        List<TodoElement> actual = service.getAllTodoElement();
        //THEN
        List<TodoElement> expected = List.of(new TodoElement(1,"hello","test"),new TodoElement(2,"test2","wtf"));
        assertEquals(expected,actual);
    }

    @Test
    void postNewElementReturnsAddedTodoElement() {
        TodoService service = getServiceObject();
        //GIVEN
        when(service.postNewElement(new TodoElement(null,"hallo","tschau"))).thenReturn(new TodoElement(1,"hallo","tschau"));
        //WHEN
        TodoElement actual = service.postNewElement(new TodoElement(null,"hallo","tschau"));
        //THEN
        TodoElement expected = new TodoElement(1,"hallo","tschau");
        assertEquals(expected, actual);
    }

    @Test
    void toChangeReturnsChangedTodoElement() {
        TodoService service = getServiceObject();
        //GIVEN
        when(service.toChange(new TodoElement(1,"hallo","tschau"))).thenReturn(new TodoElement(1,"hallo","hallo"));
        //WHEN
        TodoElement actual = service.toChange(new TodoElement(1,"hallo","tschau"));
        //THEN
        TodoElement expected = new TodoElement(1,"hallo","hallo");
        assertEquals(expected, actual);
    }

    @Test
    void showDetailsReturnsTodoElement() {
        TodoService service = getServiceObject();
        //GIVEN
        when(service.showDetails("1")).thenReturn(new TodoElement(1,"hallo","hallo"));
        //WHEN
        TodoElement actual = service.showDetails("1");
        //THEN
        TodoElement expected = new TodoElement(1,"hallo","hallo");
        assertEquals(expected, actual);
    }

    @Test
    void deleteElementReturnsDeletedTodoElement() {
        TodoService service = getServiceObject();
        //GIVEN
        when(service.deleteElement("1")).thenReturn(new TodoElement(1,"hallo","hallo"));
        //WHEN
        TodoElement actual = service.deleteElement("1");
        //THEN
        TodoElement expected = new TodoElement(1,"hallo","hallo");
        assertEquals(expected, actual);
    }

    private static TodoService getServiceObject() {
        TodoRepo repo = mock(TodoRepo.class);
        return new TodoService(repo);
    }
}