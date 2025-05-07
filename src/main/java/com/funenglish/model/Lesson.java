package com.funenglish.model;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "lessons")
public class Lesson {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String title;

    @Column(nullable = false, columnDefinition = "TEXT")
    private String content;

    @Column(nullable = false)
    private String level;

    @Column(name = "order_number")
    private Integer orderNumber;
} 