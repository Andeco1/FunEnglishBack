package com.example.FunEnglishServer.model;

import jakarta.persistence.*;

@Entity
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false)
    private String login;
    @Column(nullable = false)
    private String pasword_hash;

    public String getPassword() {
        return pasword_hash;
    }

    public Long getId() {
        return id;
    }
}
