package com.example.FunEnglishServer.service;

import com.example.FunEnglishServer.model.Level;
import com.example.FunEnglishServer.repository.LevelRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import jakarta.persistence.EntityNotFoundException;
import java.util.List;

@Service
@RequiredArgsConstructor
public class LevelService {
    private final LevelRepository repository;

    @Transactional(readOnly = true)
    public List<Level> getAll() {
        return repository.findAll();
    }

    @Transactional(readOnly = true)
    public Level getById(Integer id) {
        return repository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Level not found with id: " + id));
    }

    @Transactional(readOnly = true)
    public Level getByCode(String code) {
        return repository.findByCode(code);
    }



    @Transactional
    public void delete(Integer id) {
        if (!repository.existsById(id)) {
            throw new EntityNotFoundException("Level not found with id: " + id);
        }
        repository.deleteById(id);
    }
} 