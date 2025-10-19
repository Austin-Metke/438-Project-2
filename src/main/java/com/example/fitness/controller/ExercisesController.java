package com.example.fitness.controller;
import com.example.fitness.services.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/exercises")
public class ExercisesController {
    private final UserService userService;

    public ExercisesController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/exercise/{id}")
    public ResponseEntity<String> getUserName(@PathVariable Long id){
        String name = userService.getNameById(id);
        return new ResponseEntity<>(name, HttpStatus.OK);
    }
}
