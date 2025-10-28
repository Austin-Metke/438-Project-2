package com.example.fitness.services;

import org.springframework.stereotype.Service;

import com.example.fitness.entity.ExercisesEntity;
import com.example.fitness.repository.ExercisesRepository;
import java.util.List;

@Service
public class ExercisesService {
  private final ExercisesRepository repo;
  public ExercisesService(ExercisesRepository repo) { this.repo = repo; }

  public String getNameById(Long id) {
    ExercisesEntity ex = repo.findById(id)
        .orElseThrow(() -> new IllegalArgumentException("Exercise not found: " + id));
    return ex.getName();
  }

  public List<ExercisesEntity> getAllExercises(){
    List<ExercisesEntity> ex = repo.findAll();
    return ex;
  }
}
