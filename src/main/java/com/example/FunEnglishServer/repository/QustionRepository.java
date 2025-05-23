package com.example.FunEnglishServer.repository;

import com.example.FunEnglishServer.model.Question;
import com.example.FunEnglishServer.model.Test;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface QustionRepository extends JpaRepository<Question, Long> {
    @Query("SELECT q FROM Question q WHERE q.test.test_id = :testId")
    List<Question> findByTestId(@Param("testId") Long testId);
}
