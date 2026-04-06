package com.godoy.to_do_api.controller;

import com.godoy.to_do_api.dto.TodoRequestDto;
import com.godoy.to_do_api.dto.TodoResponseDto;
import com.godoy.to_do_api.model.TodoStatus;
import com.godoy.to_do_api.service.TodoService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/v1/todos")
@RequiredArgsConstructor
public class TodoController {

    private final TodoService todoService;

    @GetMapping
    public ResponseEntity<Page<TodoResponseDto>> findAll(
            @PageableDefault(size = 10, sort = "createdAt", direction = Sort.Direction.DESC) Pageable pageable
            ) {
        return ResponseEntity.ok(todoService.findAll(pageable));
    }

    @GetMapping("/{id}")
    public ResponseEntity<TodoResponseDto> findById(@PathVariable UUID id) {
        return ResponseEntity.ok(todoService.findById(id));
    }

    @PostMapping
    public ResponseEntity<TodoResponseDto> create(@Valid @RequestBody TodoRequestDto dto) {
        return ResponseEntity.status(HttpStatus.CREATED).body(todoService.create(dto));
    }

    @PutMapping("/{id}")
    public ResponseEntity<TodoResponseDto> update(@PathVariable UUID id,
                                                  @RequestBody TodoRequestDto dto) {
        return ResponseEntity.ok(todoService.update(id, dto));
    }

    @PatchMapping("/{id}/status")
    public ResponseEntity<TodoResponseDto> updateStatus(@PathVariable UUID id,
                                                        @RequestParam TodoStatus status) {
        return ResponseEntity.ok(todoService.updateStatus(id, status));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable UUID id) {
        todoService.delete(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }
}
