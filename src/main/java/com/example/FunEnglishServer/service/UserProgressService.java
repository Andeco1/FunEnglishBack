package com.example.FunEnglishServer.service;

import com.example.FunEnglishServer.model.Question;
import com.example.FunEnglishServer.model.UserProgress;
import com.example.FunEnglishServer.repository.UserProgressRepository;
import com.example.FunEnglishServer.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import jakarta.persistence.EntityNotFoundException;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserProgressService {
    private final UserProgressRepository repository;
    private final UserRepository userRepository;

    @Transactional(readOnly = true)
    public List<UserProgress> getAll() {
        return repository.findAll();
    }

    @Transactional(readOnly = true)
    public List<UserProgress> getByUserId(Long userId) {
        if (!userRepository.existsById(userId)) {
            throw new EntityNotFoundException("User not found with id: " + userId);
        }
        return repository.findByUserId(userId);
    }

    @Transactional
    public UserProgress saveProgress(UserProgress progress) {
        return repository.save(progress);
    }
}
