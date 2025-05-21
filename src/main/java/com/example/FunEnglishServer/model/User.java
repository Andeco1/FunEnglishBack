package com.example.FunEnglishServer.model;

import jakarta.persistence.*;
import lombok.Data;
import java.util.List;

@Data
@Entity
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_id")
    private Long userId;

    @Column(nullable = false, unique = true)
    private String login;

    @Column(name = "password_hash", nullable = false)
    private String passwordHash;

    @OneToMany(mappedBy = "user")
    private List<UserProgress> progress;

    public String getPassword() {
        return passwordHash;
    }

    public String getLogin() {
        return login;
    }

    public Long getId() {
        return userId;
    }

    public User() {
    }

    public User(String login, String passwordHash) {
        this.login = login;
        this.passwordHash = passwordHash;
    }
}
