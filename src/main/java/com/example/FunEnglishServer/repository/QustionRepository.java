package com.example.FunEnglishServer.repository;

import com.example.FunEnglishServer.model.Question;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface QustionRepository extends JpaRepository<Question, Long> {
}
