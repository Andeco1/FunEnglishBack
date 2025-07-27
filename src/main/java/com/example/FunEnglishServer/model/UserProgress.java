package com.example.FunEnglishServer.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import lombok.Data;
import java.time.ZonedDateTime;

@Data
@Entity
@Table(name = "users_progress")
public class UserProgress {
    @EmbeddedId
    private UserProgressId id;

    @JsonProperty("user_id")
    public Long getUserId() {
        return id != null ? id.getUser_id() : null;
    }

    @JsonProperty("test_id")
    public Long getTestId() {
        return id != null ? id.getTest_id() : null;
    }

    @JsonBackReference
    @ManyToOne(fetch = FetchType.LAZY)
    @MapsId("user_id")
    @JoinColumn(name = "user_id")
    private User user;

    @ManyToOne(fetch = FetchType.EAGER)
    @MapsId("test_id")
    @JoinColumn(name = "test_id")
    private Test test;

    @Column
    private Long score;

    @Column(name = "passed_at")
    private ZonedDateTime passedAt;
}