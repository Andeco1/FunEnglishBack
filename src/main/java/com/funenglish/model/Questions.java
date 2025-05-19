package com.funenglish.model;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Data
@Entity
@Table(name = "test_questions")
public class Questions {
    @Id
    @Column(name = "id")
    public long id;

    @Column(name = "test_id")
    public long testId;

    @Column(name = "question_text")
    public String questionText;

    @Column(name = "correct_answer")
    public String correctAnswer;

    @Column(name = "options")
    public List<String> options;

    @Column(name = "points")
    public int points;
}
