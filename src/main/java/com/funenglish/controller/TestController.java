package com.funenglish.controller;

import com.funenglish.model.Test;
import com.funenglish.service.TestService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/tests")
@RequiredArgsConstructor
public class TestController {
    private final TestService service;

    @GetMapping
    public ResponseEntity<List<Test>> getAll() {
        return ResponseEntity.ok(service.getAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Test> getById(@PathVariable Long id) {
        return ResponseEntity.ok(service.getById(id));
    }

    @GetMapping("/level/{level}")
    public ResponseEntity<List<Test>> getByLevel(@PathVariable String level) {
        return ResponseEntity.ok(service.getByLevel(level));
    }

    @PostMapping
    public ResponseEntity<Test> create(@RequestBody Test test) {
        return ResponseEntity.ok(service.create(test));
    }

    @PostMapping("/all")
    public ResponseEntity<List<Test>> createAll(@RequestBody List<Test> tests) {
        return ResponseEntity.ok(service.createAll(tests));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Test> update(
            @PathVariable Long id,
            @RequestBody Test test
    ) {
        return ResponseEntity.ok(service.update(id, test));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        service.delete(id);
        return ResponseEntity.ok().build();
    }
} 