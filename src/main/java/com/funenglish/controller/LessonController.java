package com.funenglish.controller;

import com.funenglish.model.Lesson;
import com.funenglish.service.LessonService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/lessons")
@RequiredArgsConstructor
public class LessonController {
    private final LessonService service;

    @GetMapping
    public ResponseEntity<List<Lesson>> getAll() {
        return ResponseEntity.ok(service.getAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Lesson> getById(@PathVariable Long id) {
        return ResponseEntity.ok(service.getById(id));
    }

    @GetMapping("/level/{level}")
    public ResponseEntity<List<Lesson>> getByLevel(@PathVariable String level) {
        return ResponseEntity.ok(service.getByLevel(level));
    }

    @PostMapping
    public ResponseEntity<Lesson> create(@RequestBody Lesson lesson) {
        return ResponseEntity.ok(service.create(lesson));
    }

    @PostMapping("/all")
    public ResponseEntity<List<Lesson>> createAll(@RequestBody List<Lesson> lessons) {
        return ResponseEntity.ok(service.createAll(lessons));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Lesson> update(
            @PathVariable Long id,
            @RequestBody Lesson lesson
    ) {
        return ResponseEntity.ok(service.update(id, lesson));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        service.delete(id);
        return ResponseEntity.ok().build();
    }
} 