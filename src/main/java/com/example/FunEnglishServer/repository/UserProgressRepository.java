package com.example.FunEnglishServer.repository;

import com.example.FunEnglishServer.model.UserProgress;
import com.example.FunEnglishServer.model.UserProgressId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface UserProgressRepository extends JpaRepository<UserProgress, UserProgressId> {
    @Query("SELECT up FROM UserProgress up " +
           "LEFT JOIN FETCH up.test t " +
           "LEFT JOIN FETCH t.level " +
           "WHERE up.id.user_id = :userId " +
           "ORDER BY up.passedAt DESC")
    List<UserProgress> findByUserId(@Param("userId") Long userId);
}
