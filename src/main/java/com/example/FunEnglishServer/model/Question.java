package com.example.FunEnglishServer.model;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Data
@Entity
public class Question {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long question_id;

    @Column(nullable = false)
    private Long test_id;

    @Column(columnDefinition = "TEXT", nullable = false)
    private String question;

    @Column(nullable = false)
    private String correct_answer;

    @Column(nullable = false)
    private Long points;

    @Column(nullable = false)
    private List<String> options;
}
