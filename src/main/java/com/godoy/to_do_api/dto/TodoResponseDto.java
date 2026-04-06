package com.godoy.to_do_api.dto;

import com.godoy.to_do_api.model.TodoStatus;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.UUID;

public record TodoResponseDto(
        UUID id,
        String title,
        String description,
        TodoStatus status,
        LocalDate dueDate,
        LocalDateTime createdAt
) {}
