package com.example.FunEnglishServer.controller;

import com.example.FunEnglishServer.model.User;
import com.example.FunEnglishServer.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("api/users")
@RequiredArgsConstructor
public class UserController {
    private final UserService service;

    @GetMapping
    public ResponseEntity<List<User>> getAll(){
        return ResponseEntity.ok(service.getAll());
    }

    @GetMapping("/{login}")
    public ResponseEntity<User> getUserByLogin(@PathVariable String login){
        return ResponseEntity.ok(service.getByLogin(login));
    }

    @PostMapping(value = "/login", consumes = "application/x-www-form-urlencoded", produces = "application/json")
    public ResponseEntity<Map<String, Object>> login(@RequestParam("login") String login, @RequestParam("pasword_hash") String pasword_hash) {
        return ResponseEntity.ok(service.login(login, pasword_hash));
    }
}
