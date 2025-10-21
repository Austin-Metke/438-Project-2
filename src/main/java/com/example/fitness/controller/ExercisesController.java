// src/main/java/com/example/fitness/controller/ExercisesController.java
package com.example.fitness.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.fitness.services.ExercisesService;

@RestController
@RequestMapping("/api/exercises")
public class ExercisesController {
  private final ExercisesService exercisesService;
  public ExercisesController(ExercisesService exercisesService) { this.exercisesService = exercisesService; }

  @GetMapping("/exercise")
  public ResponseEntity<String> getExerciseName(@PathVariable Long id){
    return ResponseEntity.ok(exercisesService.getNameById(id));
  }
}
