package com.funenglish.service;

import com.funenglish.model.Book;
import com.funenglish.repository.BookRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class BookService {
    private final BookRepository repo;

    @Transactional(readOnly = true)
    public List<Book> getAll() {
        return repo.findAll();
    }

    @Transactional(readOnly = true)
    public Book getById(Long id) {
        return repo.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Book not found: " + id));
    }

    @Transactional(readOnly = true)
    public List<Book> getByLevel(String level) {
        return repo.findByLevel(level);
    }

    @Transactional(readOnly = true)
    public List<Book> getByAuthor(String author) {
        return repo.findByAuthor(author);
    }

    @Transactional
    public Book create(Book book) {
        return repo.save(book);
    }

    @Transactional
    public List<Book> createAll(List<Book> books) {
        return repo.saveAll(books);
    }

    @Transactional
    public Book update(Long id, Book updated) {
        Book existing = repo.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Book not found: " + id));
        existing.setTitle(updated.getTitle());
        existing.setAuthor(updated.getAuthor());
        existing.setText(updated.getText());
        existing.setLevel(updated.getLevel());
        return repo.save(existing);
    }

    @Transactional
    public void delete(Long id) {
        repo.deleteById(id);
    }
} 