package com.example.fitness.entity;
import jakarta.persistence.*;

@Entity
@Table(name = "exercises")
public class ExercisesEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String description;
    private String muscle_group;
    private String type;
    private String equipment;
    private String difficulty;
    private String instructions;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
