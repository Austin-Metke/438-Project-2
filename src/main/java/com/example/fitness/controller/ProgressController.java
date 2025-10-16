package com.example.fitness.controller;

import com.example.fitness.entity.Progress;
import com.example.fitness.repository.ProgressRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Optional;

/**
 * ProgressController handles all HTTP requests related to progress tracking
 * This is where the API endpoints are defined for the React Native app
 * Works directly with the repository for simple CRUD operations
 */
@RestController
@RequestMapping("/api/progress")
@CrossOrigin(origins = "*") // Allows React Native app to call this API
public class ProgressController {
    
    @Autowired
    private ProgressRepository progressRepository;
    
    /**
     * Get all progress entries for a specific user
     */
    @GetMapping("/user/{userId}")
    public ResponseEntity<List<Progress>> getAllProgressByUserId(@PathVariable Long userId) {
        List<Progress> progressList = progressRepository.findByUserIdOrderByDateDesc(userId);
        return ResponseEntity.ok(progressList);
    }
    
    /**
     * Get a specific progress entry by its ID
     * Returns 404 if the progress entry doesn't exist
     */
    @GetMapping("/{id}")
    public ResponseEntity<Progress> getProgressById(@PathVariable Long id) {
        Optional<Progress> progress = progressRepository.findById(id);
        return progress.map(ResponseEntity::ok)
                      .orElse(ResponseEntity.notFound().build());
    }
    
    /**
     * Create a new progress entry
    */
    @PostMapping
    public ResponseEntity<Progress> createProgress(@RequestBody Progress progress) {
        try {
            Progress savedProgress = progressRepository.save(progress);
            return ResponseEntity.status(HttpStatus.CREATED).body(savedProgress);
        } catch (Exception e) {
            // Return 400 Bad Request if something goes wrong
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
    }
    
    /**
     * Update an existing progress entry
     */
    @PutMapping("/{id}")
    public ResponseEntity<Progress> updateProgress(@PathVariable Long id, @RequestBody Progress progress) {
        Optional<Progress> existingProgress = progressRepository.findById(id);
        if (existingProgress.isPresent()) {
            progress.setId(id); // Make sure we keep the same ID
            Progress updatedProgress = progressRepository.save(progress);
            return ResponseEntity.ok(updatedProgress);
        } else {
            return ResponseEntity.notFound().build();
        }
    }
    
    /**
     * Delete a progress entry
     */
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteProgress(@PathVariable Long id) {
        if (progressRepository.existsById(id)) {
            progressRepository.deleteById(id);
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
