package com.example.fitness.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.fitness.entity.ExercisesEntity;

public interface ExercisesRepository extends JpaRepository<ExercisesEntity, Long> { }
