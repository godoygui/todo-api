package com.godoy.to_do_api.dto;

import jakarta.validation.constraints.FutureOrPresent;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

import java.time.LocalDate;

public record TodoRequestDto(
        @NotBlank(message = "Título obrigatório.")
        @Size(max = 100)
        String title,

        String description,

        @NotNull(message = "Data limite é obrigatória")
        @FutureOrPresent
        LocalDate dueDate
) {}
