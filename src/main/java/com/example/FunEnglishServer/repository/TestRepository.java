package com.example.FunEnglishServer.repository;

import com.example.FunEnglishServer.model.Test;
import com.example.FunEnglishServer.model.Level;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface TestRepository extends JpaRepository<Test, Long> {
    // Basic CRUD operations are provided by JpaRepository
    
    // Find by Level entity
    List<Test> findByLevel(Level level);
    
    // Find by Level ID using JPQL query
    @Query("SELECT t FROM Test t WHERE t.level.level_id = :levelId")
    List<Test> findByLevelId(@Param("levelId") Integer levelId);
}
