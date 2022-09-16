package com.example.backend.Elements;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

@Data
@AllArgsConstructor
@NoArgsConstructor


public class TodoElement {
    private int id;
    private String description;
    private String status;
}
