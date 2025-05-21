package com.example.FunEnglishServer.model;

import jakarta.persistence.*;
import lombok.Data;
import java.time.ZonedDateTime;

@Data
@Entity
@Table(name = "users_progress")
public class UserProgress {
    @EmbeddedId
    private UserProgressId id;

    @ManyToOne
    @MapsId("userId")
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    @ManyToOne
    @MapsId("testId")
    @JoinColumn(name = "test_id", nullable = false)
    private Test test;

    @Column
    private Long score;

    @Column(name = "passed_at")
    private ZonedDateTime passedAt;
}
