package com.example.fitness.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "personal_best")
public class PersonalBest {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @Column(name = "progress_id", nullable = false)
    private Long progressId;
    
    @Column(name = "exercise", nullable = false)
    private String exercise;
    
    @Column(name = "weight", nullable = false)
    private Double weight;
    
    @Column(name = "reps", nullable = false)
    private Integer reps;
    
    @Column(name = "sets")
    private Integer sets;
    
    @Column(name = "notes")
    private String notes;
    
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "progress_id", insertable = false, updatable = false)
    private Progress progress;
    
    // Constructors
    public PersonalBest() {}
    
    public PersonalBest(Long progressId, String exercise, Double weight, Integer reps, Integer sets, String notes) {
        this.progressId = progressId;
        this.exercise = exercise;
        this.weight = weight;
        this.reps = reps;
        this.sets = sets;
        this.notes = notes;
    }
    
    // Getters and Setters
    public Long getId() {
        return id;
    }
    
    public void setId(Long id) {
        this.id = id;
    }
    
    public Long getProgressId() {
        return progressId;
    }
    
    public void setProgressId(Long progressId) {
        this.progressId = progressId;
    }
    
    public String getExercise() {
        return exercise;
    }
    
    public void setExercise(String exercise) {
        this.exercise = exercise;
    }
    
    public Double getWeight() {
        return weight;
    }
    
    public void setWeight(Double weight) {
        this.weight = weight;
    }
    
    public Integer getReps() {
        return reps;
    }
    
    public void setReps(Integer reps) {
        this.reps = reps;
    }
    
    public Integer getSets() {
        return sets;
    }
    
    public void setSets(Integer sets) {
        this.sets = sets;
    }
    
    public String getNotes() {
        return notes;
    }
    
    public void setNotes(String notes) {
        this.notes = notes;
    }
    
    public Progress getProgress() {
        return progress;
    }
    
    public void setProgress(Progress progress) {
        this.progress = progress;
    }
}
