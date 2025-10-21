package com.example.fitness.services;

import com.example.fitness.entity.ExercisesEntity;
import com.example.fitness.entity.UserRepository;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {this.userRepository = userRepository;}

    public String getNameById(Long id) {
        ExercisesEntity exercise = userRepository.getFirstById(id);
        return exercise.getName();
    }
}
