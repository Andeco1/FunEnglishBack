package com.example.FunEnglishServer.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.Data;
import java.time.ZonedDateTime;

@Data
@Entity
@Table(name = "users_progress")
public class UserProgress {
    @EmbeddedId
    private UserProgressId id;

    @JsonBackReference
    @ManyToOne
    @MapsId("user_id")
    @JoinColumn(name = "user_id")
    private User user;

    @JsonBackReference
    @ManyToOne
    @MapsId("test_id")
    @JoinColumn(name = "test_id")
    private Test test;

    @Column
    private Long score;

    @Column(name = "passed_at")
    private ZonedDateTime passedAt;
}