package com.example.backend.Controller;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
class ControllerTest {

    @Autowired
    private MockMvc mvc;

    //TODO: Extract mvc Object instantziater
    @Test
    void getAllTodoElementShouldReturnListWithAllElements() throws Exception {
        //GIVEN
        String requestedBody1 = """
                {"id":5,"description":"Tschau","status":"DONE"}
                """;
        mvc.perform(MockMvcRequestBuilders.put("/api/todo/5")
                .header(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE)
                .content(requestedBody1));
        String requestedBody2 = """
                {"id":1,"description":"dsfsdfdsf","status":"OPEN"}
                """;
        mvc.perform(MockMvcRequestBuilders.put("/api/todo/1")
                .header(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE)
                .content(requestedBody2));
        String expected = """
                [{"id":1,"description":"dsfsdfdsf","status":"OPEN"},{"id":5,"description":"Tschau","status":"DONE"}]
                """;
        //WTHEN
        mvc.perform(MockMvcRequestBuilders.get("/api/todo/"))
                .andExpect(status().isOk())
                .andExpect(content().json(expected));
    }

    @Test
    void requestElementSholdReturnPostedTodoElement() throws Exception {
        //GIVEN
        String requestBody = """
                {"description":"dsfsdfdsf","status":"OPEN"}
                """;
        String expected = """
                {"id":1,"description":"dsfsdfdsf","status":"OPEN"}
                """;
        //WTHEN
        mvc.perform(MockMvcRequestBuilders.post("/api/todo/")
                        .header(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE)
                        .content(requestBody))
                .andExpect(status().isOk())
                .andExpect(content().json(expected));

    }

    @Test
    void changeStatusShouldReturnChangedIdElement() throws Exception {
        //GIVEN
        String requestedBody = """
                {"id":5,"description":"Tschau","status":"DONE"}
                """;
        String expected = """
                {"id":5,"description":"Tschau","status":"DONE"}
                """;

        //WTHEN
        mvc.perform(MockMvcRequestBuilders.put("/api/todo/5")
                        .header(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE)
                        .content(requestedBody))
                .andExpect(status().isOk())
                .andExpect(content().json(expected));

    }

    @Test
    void showDetailsShouldReturnSelectedTodoElement() throws Exception {
        //GIVEN
        String requestedBody = """
                {"id":5,"description":"Tschau","status":"DONE"}
                """;
        mvc.perform(MockMvcRequestBuilders.put("/api/todo/5")
                .header(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE)
                .content(requestedBody));

        String expected = """
                {"id":5,"description":"Tschau","status":"DONE"}
                """;
        //WTHEN
        mvc.perform(MockMvcRequestBuilders.get("/api/todo/5"))
                .andExpect(status().isOk())
                .andExpect(content().json(expected));
    }

    @Test
    void deleteElementShouldReturnDeletedTodoElement() throws Exception {
        //GIVEN
        String requestedBody = """
                {"id":5,"description":"Tschau","status":"DONE"}
                """;
        mvc.perform(MockMvcRequestBuilders.put("/api/todo/5")
                .header(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE)
                .content(requestedBody));

        String expected = """
                {"id":5,"description":"Tschau","status":"DONE"}
                """;
        //WTHEN
        mvc.perform(MockMvcRequestBuilders.delete("/api/todo/5"))
                .andExpect(status().isOk())
                .andExpect(content().json(expected));
    }
}