package com.example.FunEnglishServer.model;

import jakarta.persistence.*;
import lombok.Data;
import java.util.List;

@Data
@Entity
@Table(name = "test")
public class Test {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "test_id")
    private Long testId;

    @Column(nullable = false)
    private String title;

    @ManyToOne
    @JoinColumn(name = "level_id", nullable = false)
    private Level level;

    @OneToMany(mappedBy = "test", cascade = CascadeType.ALL)
    private List<Question> questions;

    @OneToMany(mappedBy = "test")
    private List<UserProgress> userProgresses;
}
