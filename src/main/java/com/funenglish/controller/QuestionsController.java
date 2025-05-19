package com.funenglish.controller;

import com.funenglish.model.Questions;
import com.funenglish.service.QuestionsService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/test_questions")
@RequiredArgsConstructor
public class QuestionsController {
    private final QuestionsService service;

    @GetMapping
    public ResponseEntity<List<Questions>> getAll() {
        return ResponseEntity.ok(service.getAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Questions> getById(Long id) {
        return ResponseEntity.ok(service.getById(id));
    }


    @PostMapping
    public ResponseEntity<Questions> create(@RequestBody Questions q) {
        return ResponseEntity.ok(service.create(q));
    }

    @PostMapping("/all")
    public ResponseEntity<List<Questions>> createAll(@RequestBody List<Questions> q) {
        return ResponseEntity.ok(service.createAll(q));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        service.delete(id);
        return ResponseEntity.ok().build();
    }
}