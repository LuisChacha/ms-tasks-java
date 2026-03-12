package com.example.mstasks.service;

import com.example.mstasks.model.Task;
import com.example.mstasks.repository.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class TaskService {

    @Autowired
    private TaskRepository taskRepository;

    public Task createTask(Task task) {
        return taskRepository.save(task);
    }

    public List<Task> getTasksByUser(Long userId) {
        return taskRepository.findByUserId(userId);
    }
}