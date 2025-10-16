package com.example.fitness.repository;

import com.example.fitness.entity.Progress;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface ProgressRepository extends JpaRepository<Progress, Long> {
    
    List<Progress> findByUserIdOrderByDateDesc(Long userId);
    
    Progress findTopByUserIdOrderByDateDesc(Long userId);
    
    Progress findTop2ByUserIdOrderByDateDesc(Long userId);
}
