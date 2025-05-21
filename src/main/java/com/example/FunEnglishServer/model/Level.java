package com.example.FunEnglishServer.model;

import jakarta.persistence.*;
import lombok.Data;
import java.util.List;

@Data
@Entity
@Table(name = "level")
public class Level {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "level_id")
    private Integer levelId;

    @Column(nullable = false, unique = true)
    private String code;

    @Column
    private String description;

    @OneToMany(mappedBy = "level")
    private List<Lesson> lessons;

    @OneToMany(mappedBy = "level")
    private List<Test> tests;
} 