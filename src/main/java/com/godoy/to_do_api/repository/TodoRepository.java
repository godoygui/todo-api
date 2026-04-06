package com.godoy.to_do_api.repository;

import com.godoy.to_do_api.model.TodoEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface TodoRepository extends JpaRepository<TodoEntity, UUID> {
}
