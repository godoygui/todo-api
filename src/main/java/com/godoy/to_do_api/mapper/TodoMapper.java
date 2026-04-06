package com.godoy.to_do_api.mapper;

import com.godoy.to_do_api.dto.TodoRequestDto;
import com.godoy.to_do_api.dto.TodoResponseDto;
import com.godoy.to_do_api.model.TodoEntity;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface TodoMapper {

    TodoEntity toEntity(TodoRequestDto dto);

    TodoResponseDto toResponse(TodoEntity entity);

    List<TodoResponseDto> toResponseList(List<TodoEntity> todos);
}
