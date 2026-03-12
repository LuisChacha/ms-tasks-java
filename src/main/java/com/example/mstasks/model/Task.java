package com.example.mstasks.model;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "tasks") // Esta será la tabla nueva en tu DB
@Data
public class Task {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;
    private String description;
    private boolean completed;
    private Long userId; // Aquí guardaremos el ID del usuario que viene de Python
}