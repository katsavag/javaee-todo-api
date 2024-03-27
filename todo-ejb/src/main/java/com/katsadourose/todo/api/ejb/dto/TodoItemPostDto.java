package com.katsadourose.todo.api.ejb.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.validation.constraints.Future;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDate;

public record TodoItemPostDto (
        @NotBlank
        String title,
        String description,
        @Future
        @NotNull
        @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm a z")
        LocalDate dueDate,
        String priority,
        String category,
        @NotBlank
        String user
){
}
