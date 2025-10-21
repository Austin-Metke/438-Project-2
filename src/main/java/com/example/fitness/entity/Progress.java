package com.example.fitness.entity;

import jakarta.persistence.*;
import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name = "progress")
public class Progress {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @Column(name = "user_id", nullable = false)
    private Long userId;
    
    @Column(name = "date", nullable = false)
    private LocalDate date;
    
    @Column(name = "weight", nullable = false)
    private Double weight;
    
    @Column(name = "bf_percentage", nullable = false)
    private Double bfPercentage;
    
    @OneToMany(mappedBy = "progress", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<PersonalBest> personalBests;
    
    // Constructors
    public Progress() {}
    
    public Progress(Long userId, LocalDate date, Double weight, Double bfPercentage) {
        this.userId = userId;
        this.date = date;
        this.weight = weight;
        this.bfPercentage = bfPercentage;
    }
    
    // Getters and Setters
    public Long getId() {
        return id;
    }
    
    public void setId(Long id) {
        this.id = id;
    }
    
    public Long getUserId() {
        return userId;
    }
    
    public void setUserId(Long userId) {
        this.userId = userId;
    }
    
    public LocalDate getDate() {
        return date;
    }
    
    public void setDate(LocalDate date) {
        this.date = date;
    }
    
    public Double getWeight() {
        return weight;
    }
    
    public void setWeight(Double weight) {
        this.weight = weight;
    }
    
    public Double getBfPercentage() {
        return bfPercentage;
    }
    
    public void setBfPercentage(Double bfPercentage) {
        this.bfPercentage = bfPercentage;
    }
    
    public List<PersonalBest> getPersonalBests() {
        return personalBests;
    }
    
    public void setPersonalBests(List<PersonalBest> personalBests) {
        this.personalBests = personalBests;
    }
}
