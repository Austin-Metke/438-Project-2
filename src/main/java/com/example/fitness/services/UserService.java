package com.example.fitness.services;
import org.springframework.stereotype.Service;

import com.example.fitness.entity.User;
import com.example.fitness.repository.UserRepository;

@Service
public class UserService {
    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public String getNameById(Long id) {
        User user = userRepository.getUsernameById(id);
        return user.getUsername();
    }
}
