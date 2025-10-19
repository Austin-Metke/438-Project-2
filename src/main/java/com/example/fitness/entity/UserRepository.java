package com.example.fitness.entity;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<ExercisesEntity, Long> {
    ExercisesEntity getFirstById(Long id);
}
