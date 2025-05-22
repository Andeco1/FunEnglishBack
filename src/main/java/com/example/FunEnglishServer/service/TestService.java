package com.example.FunEnglishServer.service;

import com.example.FunEnglishServer.model.Test;
import com.example.FunEnglishServer.model.Level;
import com.example.FunEnglishServer.repository.TestRepository;
import com.example.FunEnglishServer.repository.LevelRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import jakarta.persistence.EntityNotFoundException;
import java.util.List;

@Service
@RequiredArgsConstructor
public class TestService {
    private final TestRepository repository;
    private final LevelRepository levelRepository;

    @Transactional(readOnly = true)
    public List<Test> getAll() {
        return repository.findAll();
    }

    @Transactional(readOnly = true)
    public Test getById(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Test not found with id: " + id));
    }
    @Transactional(readOnly = true)
    public List<Test> getByLevelId(Integer levelId) {
        Level level = levelRepository.findById(levelId)
                .orElseThrow(() -> new EntityNotFoundException("Level not found with id: " + levelId));
        return repository.findByLevel(level);
    }

    @Transactional
    public Test create(Test test) {
        Level level = levelRepository.findById(test.getLevel().getLevel_id())
                .orElseThrow(() -> new EntityNotFoundException("Level not found with id: " + test.getLevel().getLevel_id()));
        test.setLevel(level);
        return repository.save(test);
    }

    @Transactional
    public Test update(Long id, Test test) {
        Test existingTest = getById(id);
        Level level = levelRepository.findById(test.getLevel().getLevel_id())
                .orElseThrow(() -> new EntityNotFoundException("Level not found with id: " + test.getLevel().getLevel_id()));
        test.setTest_id(id);
        test.setLevel(level);
        return repository.save(test);
    }

    @Transactional
    public void delete(Long id) {
        if (!repository.existsById(id)) {
            throw new EntityNotFoundException("Test not found with id: " + id);
        }
        repository.deleteById(id);
    }
}
