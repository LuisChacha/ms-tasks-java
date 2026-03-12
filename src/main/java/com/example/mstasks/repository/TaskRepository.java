package com.example.mstasks.repository;

import com.example.mstasks.model.Task;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface TaskRepository extends JpaRepository<Task, Long> {
    // Método personalizado para buscar solo las tareas de un usuario
    List<Task> findByUserId(Long userId);
}