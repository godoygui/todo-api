package com.godoy.to_do_api.service;

import com.godoy.to_do_api.dto.TodoRequestDto;
import com.godoy.to_do_api.dto.TodoResponseDto;
import com.godoy.to_do_api.exception.ResourceNotFoundException;
import com.godoy.to_do_api.mapper.TodoMapper;
import com.godoy.to_do_api.model.TodoEntity;
import com.godoy.to_do_api.model.TodoStatus;
import com.godoy.to_do_api.repository.TodoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class TodoService {

    private final TodoRepository TodoRepository;
    private final TodoMapper mapper;

    public Page<TodoResponseDto> findAll(Pageable pageable) {
        return TodoRepository.findAll(pageable).map(mapper::toResponse);
    }

    public TodoResponseDto findById(UUID id) {
        return mapper.toResponse(getOrThrow(id));
    }

    public TodoResponseDto create(TodoRequestDto dto) {
        TodoEntity todo = mapper.toEntity(dto);
        return mapper.toResponse(TodoRepository.save(todo));
    }

    public TodoResponseDto update(UUID id, TodoRequestDto dto) {
        TodoEntity todo = getOrThrow(id);
        todo.setTitle(dto.title());
        todo.setDescription(dto.description());
        todo.setDueDate(dto.dueDate());
        return mapper.toResponse(TodoRepository.save(todo));
    }

    public TodoResponseDto updateStatus(UUID id, TodoStatus status) {
        TodoEntity todo =  getOrThrow(id);
        todo.setStatus(status);
        return mapper.toResponse(TodoRepository.save(todo));
    }

    public void delete(UUID id) {
        TodoRepository.delete(getOrThrow(id));
    }

    private TodoEntity getOrThrow(UUID id) {
        return TodoRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Todo não encontrado: " + id));
    }
}
