package com.example.FunEnglishServer.controller;

import com.example.FunEnglishServer.model.Question;
import com.example.FunEnglishServer.model.QuestionOption;
import com.example.FunEnglishServer.service.QuestionOptionService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import jakarta.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/question-options")
@RequiredArgsConstructor
public class QuestionOptionController {
    private final QuestionOptionService service;

    @GetMapping("/question/{questionId}")
    public ResponseEntity<List<QuestionOption>> getByQuestion(@PathVariable Question questionId) {
        return ResponseEntity.ok(service.getByQuestion(questionId));
    }

    @PostMapping
    public ResponseEntity<QuestionOption> create(@Valid @RequestBody QuestionOption option) {
        return ResponseEntity.ok(service.create(option));
    }

    @PostMapping("/batch")
    public ResponseEntity<List<QuestionOption>> createAll(@Valid @RequestBody List<QuestionOption> options) {
        return ResponseEntity.ok(service.createAll(options));
    }

    @PutMapping("/{id}")
    public ResponseEntity<QuestionOption> update(@PathVariable Long id, @Valid @RequestBody QuestionOption option) {
        return ResponseEntity.ok(service.update(id, option));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }


} 