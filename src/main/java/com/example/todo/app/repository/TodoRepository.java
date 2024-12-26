package com.example.todo.app.repository;

import com.example.todo.app.model.Todo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TodoRepository extends JpaRepository<Todo, Long> {
    // JpaRepository đã cung cấp các phương thức như findAll(), findById(), save(), deleteById() sẵn
}
