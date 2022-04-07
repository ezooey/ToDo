package com.tdl.ToDo.repository;

import com.tdl.ToDo.domain.Todo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TodoRepository extends JpaRepository<Todo, Long> {
}
