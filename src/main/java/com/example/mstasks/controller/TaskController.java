package com.example.mstasks.controller;

import com.example.mstasks.model.Task;
import com.example.mstasks.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/tasks")
public class TaskController {

    @Autowired
    private TaskService taskService;


    @GetMapping("/test")
    public String test() {
        return "Microservicio de Tareas (Java) respondiendo correctamente 🚀";
    }


    // 1. Crear una tarea (POST)
    @PostMapping("/")
    public Task create(@RequestBody Task task) {
        // Extraemos el ID del usuario (el 'sub') que viene en el token validado
        // Spring Security ya guardó el "subject" del token en el contexto
        String userIdStr = SecurityContextHolder.getContext().getAuthentication().getName();

        // Lo asignamos a la tarea antes de guardar
        task.setUserId(Long.parseLong(userIdStr));

        return taskService.createTask(task);
    }

    // 2. Listar todas las tareas del usuario logueado (GET)
    @GetMapping("/")
    public List<Task> getAll() {
        // Obtenemos el ID del usuario actual desde el contexto de seguridad
        String userIdStr = SecurityContextHolder.getContext().getAuthentication().getName();

        return taskService.getTasksByUser(Long.parseLong(userIdStr));
    }

}