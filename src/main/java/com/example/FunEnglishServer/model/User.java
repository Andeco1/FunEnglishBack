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
    private String password;

    public String getPassword() {
        return password;
    }

    public Long getId() {
        return id;
    }

    public String getLogin() {
        return login;
    }

    public User() {
    }

    public User(String login, String password) {
        this.login = login;
        this.password = password;
    }
}