package com.funenglish.controller;

import com.funenglish.model.Book;
import com.funenglish.service.BookService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/books")
@RequiredArgsConstructor
public class BookController {
    private final BookService service;

    @GetMapping
    public ResponseEntity<List<Book>> getAll() {
        return ResponseEntity.ok(service.getAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Book> getById(@PathVariable Long id) {
        return ResponseEntity.ok(service.getById(id));
    }

    @GetMapping("/level/{level}")
    public ResponseEntity<List<Book>> getByLevel(@PathVariable String level) {
        return ResponseEntity.ok(service.getByLevel(level));
    }

    @GetMapping("/author/{author}")
    public ResponseEntity<List<Book>> getByAuthor(@PathVariable String author) {
        return ResponseEntity.ok(service.getByAuthor(author));
    }

    @PostMapping
    public ResponseEntity<Book> create(@RequestBody Book book) {
        return ResponseEntity.ok(service.create(book));
    }

    @PostMapping("/all")
    public ResponseEntity<List<Book>> createAll(@RequestBody List<Book> books) {
        return ResponseEntity.ok(service.createAll(books));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Book> update(
            @PathVariable Long id,
            @RequestBody Book book
    ) {
        return ResponseEntity.ok(service.update(id, book));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        service.delete(id);
        return ResponseEntity.ok().build();
    }
} 