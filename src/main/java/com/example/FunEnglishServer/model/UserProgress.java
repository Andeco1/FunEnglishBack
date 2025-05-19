package com.example.FunEnglishServer.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import lombok.Data;

@Data
@Entity
public class UserProgress {
    @Column(nullable = false)
    private Long user_id;

    @Column(nullable = false)
    private Long test_id;

    @Column
    private Long score;
}
