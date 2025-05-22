package com.example.FunEnglishServer.service;

import com.example.FunEnglishServer.model.Question;
import com.example.FunEnglishServer.model.UserProgress;
import com.example.FunEnglishServer.model.UserProgressId;
import com.example.FunEnglishServer.model.Test;
import com.example.FunEnglishServer.model.User;
import com.example.FunEnglishServer.repository.UserProgressRepository;
import com.example.FunEnglishServer.repository.UserRepository;
import com.example.FunEnglishServer.repository.TestRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import jakarta.persistence.EntityNotFoundException;
import java.time.ZonedDateTime;
import java.util.List;
import java.util.stream.Collectors;
import com.example.FunEnglishServer.dto.UserProgressResponseDTO;

@Service
@RequiredArgsConstructor
public class UserProgressService {
    private final UserProgressRepository repository;
    private final UserRepository userRepository;
    private final TestRepository testRepository;

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

    @Transactional
    public void initializeUserProgress(Long userId) {
        User user = userRepository.findById(userId)
            .orElseThrow(() -> new EntityNotFoundException("User not found with id: " + userId));
        
        List<Test> allTests = testRepository.findAll();
        
        for (Test test : allTests) {
            UserProgressId progressId = new UserProgressId();
            progressId.setUser_id(userId);
            progressId.setTest_id(test.getTest_id());
            
            UserProgress progress = new UserProgress();
            progress.setId(progressId);
            progress.setUser(user);
            progress.setTest(test);
            progress.setScore(0L);
            progress.setPassedAt(ZonedDateTime.now());
            
            repository.save(progress);
        }
    }

    public List<UserProgressResponseDTO> getUserProgress(Long userId) {
        return repository.findByUserId(userId).stream()
                .map(progress -> new UserProgressResponseDTO(
                    progress.getTestId(),
                    progress.getTest().getTitle(),
                    progress.getTest().getLevel().getCode(),
                    progress.getScore(),
                    progress.getPassedAt()
                ))
                .collect(Collectors.toList());
    }
}
