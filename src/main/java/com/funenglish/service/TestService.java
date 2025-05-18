package com.funenglish.service;

import com.funenglish.model.Test;
import com.funenglish.repository.TestRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class TestService {
    private final TestRepository repo;

    @Transactional(readOnly = true)
    public List<Test> getAll() {
        return repo.findAll();
    }

    @Transactional(readOnly = true)
    public Test getById(Long id) {
        return repo.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Test not found: " + id));
    }

    @Transactional(readOnly = true)
    public List<Test> getByLevel(String level) {
        return repo.findByLevel(level);
    }

    @Transactional
    public Test create(Test test) {
        return repo.save(test);
    }

    @Transactional
    public List<Test> createAll(List<Test> tests) {
        return repo.saveAll(tests);
    }

    @Transactional
    public Test update(Long id, Test updated) {
        Test existing = repo.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Test not found: " + id));
        existing.setTitle(updated.getTitle());
        existing.setDescription(updated.getDescription());
        existing.setLevel(updated.getLevel());
        existing.setQuestionsCount(updated.getQuestionsCount());
        return repo.save(existing);
    }

    @Transactional
    public void delete(Long id) {
        repo.deleteById(id);
    }
} 