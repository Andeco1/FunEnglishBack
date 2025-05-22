package com.example.FunEnglishServer.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.Data;
import java.util.List;

@Data
@Entity
@Table(name = "test")
public class Test {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long test_id;

    @Column(nullable = false)
    private String title;

    @JsonBackReference
    @ManyToOne
    @JoinColumn(name = "level_id", nullable = false)
    private Level level;

    @JsonManagedReference
    @OneToMany(mappedBy = "test")
    private List<Question> questions;

    @JsonManagedReference
    @OneToMany(mappedBy = "test")
    private List<UserProgress> userProgress;

    public Long getTest_id() {
        return test_id;
    }

    public void setTest_id(Long test_id) {
        this.test_id = test_id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Level getLevel() {
        return level;
    }

    public void setLevel(Level level) {
        this.level = level;
    }
}