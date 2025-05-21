package com.example.FunEnglishServer.model;

import jakarta.persistence.*;

@Entity
public class UserProgress {
    @EmbeddedId
    private UserProgressId recordId;

    @ManyToOne
    @MapsId("user_id")
    @JoinColumn(name = "user_id")
    private User user;

    @ManyToOne
    @MapsId("test_id")
    @JoinColumn(name = "test_id")
    private Test test;

    @Column
    private Long score;
}