package com.example.todo.app.service;

import com.example.todo.app.model.Todo;  // Use the correct package for Todo
import com.example.todo.app.repository.TodoRepository;  // Use the correct package for TodoRepository
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TodoService {

    @Autowired
    private TodoRepository todoRepository;

    public List<Todo> getAllTodos() {
        return todoRepository.findAll();
    }

    public void saveTodo(Todo todo) {
        todoRepository.save(todo);
    }

    public void deleteTodoById(Long id) {
        todoRepository.deleteById(id);
    }

    public Optional<Todo> getTodoById(Long id) {
        return todoRepository.findById(id);
    }
}
