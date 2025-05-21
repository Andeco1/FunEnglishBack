package com.example.FunEnglishServer.controller;

import com.example.FunEnglishServer.model.User;
import com.example.FunEnglishServer.service.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.nio.charset.StandardCharsets;
import java.util.Base64;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("api/users")
@RequiredArgsConstructor
@Slf4j
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
    public ResponseEntity<Map<String, Object>> login(@RequestHeader("Authorization") String authorization) {
        String[] credentials = extractCredentialsFromHeader(authorization);
        String authLogin = credentials[0];
        String authPassword = credentials[1];
        return ResponseEntity.ok(service.login(authLogin, authPassword));
    }

    @PostMapping(value = "/register", consumes = "application/json", produces = "application/json")
    public ResponseEntity<Map<String, Object>> register(@RequestBody Map<String, String> credentials) {
        if (!credentials.containsKey("login") || !credentials.containsKey("password")) {
            return ResponseEntity.badRequest().body(Map.of(
                "error", "Login and password are required",
                "status", "error"
            ));
        }

        String login = credentials.get("login");
        String password = credentials.get("password");

        if (login == null || login.trim().isEmpty()) {
            return ResponseEntity.badRequest().body(Map.of(
                "error", "Login cannot be empty",
                "status", "error"
            ));
        }

        if (password == null || password.trim().isEmpty()) {
            return ResponseEntity.badRequest().body(Map.of(
                "error", "Password cannot be empty",
                "status", "error"
            ));
        }

        try {
            return ResponseEntity.ok(service.register(login, password));
        } catch (Exception e) {
            log.error("Registration failed for user: {}", login, e);
            return ResponseEntity.badRequest().body(Map.of(
                "error", e.getMessage(),
                "status", "error"
            ));
        }
    }

    private String[] extractCredentialsFromHeader(String authorizationHeader) {
        if (authorizationHeader == null || !authorizationHeader.startsWith("Basic ")) {
            throw new RuntimeException("Отсутствует или некорректный заголовок Authorization");
        }

        String base64Credentials = authorizationHeader.substring("Basic ".length());
        byte[] decodedBytes = Base64.getDecoder().decode(base64Credentials);
        String decoded = new String(decodedBytes, StandardCharsets.UTF_8);

        return decoded.split(":", 2);
    }
}
