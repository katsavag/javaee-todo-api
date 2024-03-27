package com.katsadourose.todo.api.ejb.dto;

import jakarta.validation.constraints.NotBlank;

public record CategoryPostDto (
        @NotBlank
        String name,
        String description
){
}
