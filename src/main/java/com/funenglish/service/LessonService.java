package com.funenglish.service;

import com.funenglish.model.Lesson;
import com.funenglish.repository.LessonRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class LessonService {
    private final LessonRepository repo;

    @Transactional(readOnly = true)
    public List<Lesson> getAll() {
        return repo.findAll();
    }

    @Transactional(readOnly = true)
    public Lesson getById(Long id) {
        return repo.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Lesson not found: " + id));
    }

    @Transactional(readOnly = true)
    public List<Lesson> getByLevel(String level) {
        return repo.findByLevel(level);
    }

    @Transactional
    public Lesson create(Lesson lesson) {
        return repo.save(lesson);
    }

    @Transactional
    public List<Lesson> createAll(List<Lesson> lessons) {
        return repo.saveAll(lessons);
    }

    @Transactional
    public Lesson update(Long id, Lesson updated) {
        Lesson existing = repo.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Lesson not found: " + id));
        existing.setTitle(updated.getTitle());
        existing.setContent(updated.getContent());
        existing.setLevel(updated.getLevel());
        return repo.save(existing);
    }

    @Transactional
    public void delete(Long id) {
        repo.deleteById(id);
    }
} 