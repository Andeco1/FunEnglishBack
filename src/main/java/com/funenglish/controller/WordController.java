package com.funenglish.controller;

import com.funenglish.model.Word;
import com.funenglish.service.WordService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/words")
@RequiredArgsConstructor
public class WordController {
    private final WordService service;

    @GetMapping
    public ResponseEntity<List<Word>> getAll() {
        return ResponseEntity.ok(service.getAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Word> getById(@PathVariable Long id) {
        return ResponseEntity.ok(service.getById(id));
    }

    @GetMapping("/group/{group}")
    public ResponseEntity<List<Word>> getByGroup(@PathVariable String group) {
        return ResponseEntity.ok(service.getByGroup(group));
    }

    @GetMapping("/groups")
    public ResponseEntity<List<String>> getGroups() {
        return ResponseEntity.ok(service.getGroups());
    }

    @PostMapping
    public ResponseEntity<Word> create(@RequestBody Word word) {
        return ResponseEntity.ok(service.create(word));
    }

    @PostMapping("/all")
    public ResponseEntity<List<Word>> createAll(@RequestBody List<Word> words) {
        return ResponseEntity.ok(service.createAll(words));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Word> update(
            @PathVariable Long id,
            @RequestBody Word word
    ) {
        return ResponseEntity.ok(service.update(id, word));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        service.delete(id);
        return ResponseEntity.ok().build();
    }
}