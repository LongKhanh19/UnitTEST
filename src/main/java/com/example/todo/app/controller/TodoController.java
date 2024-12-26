package com.example.todo.app.controller;

import com.example.todo.app.model.Todo;  // Corrected package for Todo
import com.example.todo.app.service.TodoService;  // Corrected package for TodoService
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/todos")
public class TodoController {

    @Autowired
    private TodoService todoService;

    // Hiển thị danh sách todos
    @GetMapping
    public String listTodos(Model model) {
        model.addAttribute("todos", todoService.getAllTodos());
        return "todos"; // trả về view tên 'todos' (cần tạo file todos.html trong resources/templates)
    }

    // Lưu Todo mới
    @PostMapping
    public String saveTodo(@ModelAttribute Todo todo) {
        todoService.saveTodo(todo);
        return "redirect:/todos"; // Sau khi lưu thành công, chuyển hướng lại trang danh sách todos
    }

    // Xóa Todo theo ID
    @GetMapping("/delete/{id}")
    public String deleteTodo(@PathVariable Long id) {
        todoService.deleteTodoById(id);
        return "redirect:/todos"; // Sau khi xóa, chuyển hướng lại trang danh sách todos
    }
}
