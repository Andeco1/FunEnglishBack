package com.example.FunEnglishServer.controller;

import com.example.FunEnglishServer.model.UserProgress;
import com.example.FunEnglishServer.service.UserProgressService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/progress")
@RequiredArgsConstructor
public class UserProgressController {
    private final UserProgressService service;

    @GetMapping
    public ResponseEntity<List<UserProgress>> getAll() {
        return ResponseEntity.ok(service.getAll());
    }

    @GetMapping("/user/{userId}")
    public ResponseEntity<List<UserProgress>> getByUserId(@PathVariable Long userId) {
        return ResponseEntity.ok(service.getByUserId(userId));
    }

    @PostMapping
    public ResponseEntity<UserProgress> saveProgress(@RequestBody UserProgress progress) {
        return ResponseEntity.ok(service.saveProgress(progress));
    }
}
