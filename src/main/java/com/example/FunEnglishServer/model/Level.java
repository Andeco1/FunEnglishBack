package com.example.FunEnglishServer.model;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.Data;
import java.util.List;

@Data
@Entity
@Table(name = "level")
public class Level {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer level_id;

    @Column(nullable = false, unique = true)
    private String code;

    @Column
    private String description;

    @JsonManagedReference
    @OneToMany(mappedBy = "level")
    private List<Lesson> lessons;

    @JsonManagedReference
    @OneToMany(mappedBy = "level")
    private List<Test> tests;
} 
