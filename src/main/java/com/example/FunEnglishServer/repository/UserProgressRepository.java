package com.example.FunEnglishServer.repository;

import com.example.FunEnglishServer.model.UserProgress;
import com.example.FunEnglishServer.model.UserProgressId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserProgressRepository extends JpaRepository<UserProgress, UserProgressId> {
}
