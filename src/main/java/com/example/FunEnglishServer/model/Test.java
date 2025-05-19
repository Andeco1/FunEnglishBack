package com.example.FunEnglishServer.model;

import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.annotations.CollectionId;

@Data
@Entity
public class Test {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long test_id;

    @Column(nullable = false)
    private String title;

    @Column(nullable = false)
    private String level;

    @Column(nullable = false)
    private Long count;
}
