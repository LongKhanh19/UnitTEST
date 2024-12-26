package com.example.todo.app.service;

import com.example.todo.app.model.Todo;
import com.example.todo.app.repository.TodoRepository;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

// Kích hoạt Mockito Extension cho JUnit 5
@ExtendWith(MockitoExtension.class)
public class TodoServiceTest {

    @Mock
    private TodoRepository todoRepository; // Giả lập TodoRepository

    @InjectMocks
    private TodoService todoService; // Inject TodoService để kiểm thử

    // Test lấy tất cả todos
    @Test
    public void testGetAllTodos() {
        // Giả lập hành vi của TodoRepository
        when(todoRepository.findAll()).thenReturn(List.of(new Todo(1L, "Test Todo", false)));

        // Kiểm tra phương thức getAllTodos()
        List<Todo> todos = todoService.getAllTodos();
        assertEquals(1, todos.size());
        assertEquals("Test Todo", todos.get(0).getName());
    }

    // Test lưu một todo
    @Test
    public void testSaveTodo() {
        Todo todo = new Todo(1L, "New Todo", false);

        // Gọi phương thức saveTodo
        todoService.saveTodo(todo);

        // Kiểm tra rằng saveTodo đã gọi save trên TodoRepository
        verify(todoRepository, times(1)).save(todo);
    }

    // Test xóa todo theo ID
    @Test
    public void testDeleteTodoById() {
        Long todoId = 1L;

        // Gọi phương thức deleteTodoById
        todoService.deleteTodoById(todoId);

        // Kiểm tra rằng deleteById đã được gọi đúng một lần trên TodoRepository
        verify(todoRepository, times(1)).deleteById(todoId);
    }

    // Test tìm todo theo ID
    @Test
    public void testGetTodoById() {
        Long todoId = 1L;
        Todo todo = new Todo(todoId, "Test Todo", false);

        // Giả lập hành vi của TodoRepository
        when(todoRepository.findById(todoId)).thenReturn(Optional.of(todo));

        // Kiểm tra phương thức getTodoById
        Optional<Todo> result = todoService.getTodoById(todoId);
        assertTrue(result.isPresent());
        assertEquals("Test Todo", result.get().getName());
    }
}
