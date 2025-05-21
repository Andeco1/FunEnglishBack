package com.example.FunEnglishServer.model;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "question_opt")
public class QuestionOption {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "option_id")
    private Long optionId;

    @ManyToOne
    @JoinColumn(name = "question_id", nullable = false)
    private Question question;

    @Column(name = "option_text", nullable = false)
    private String optionText;

    @Column(name = "is_correct", nullable = false)
    private Boolean isCorrect;
} 