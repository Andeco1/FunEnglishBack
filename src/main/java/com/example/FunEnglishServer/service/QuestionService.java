package com.example.FunEnglishServer.service;

import com.example.FunEnglishServer.dto.QuestionResponse;
import com.example.FunEnglishServer.model.Lesson;
import com.example.FunEnglishServer.model.Question;
import com.example.FunEnglishServer.repository.QustionRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import jakarta.persistence.EntityNotFoundException;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Slf4j
public class QuestionService {
    private final QustionRepository repository;

    @Transactional(readOnly = true)
    public List<QuestionResponse> getAll(){
        return repository.findAll().stream()
                .map(QuestionResponse::fromQuestion)
                .collect(Collectors.toList());
    }

    @Transactional(readOnly = true)
    public List<QuestionResponse> getByTestId(Long testId) {
        log.info("Fetching questions for test ID: {}", testId);
        List<QuestionResponse> questions = repository.findByTestId(testId).stream()
                .map(QuestionResponse::fromQuestion)
                .collect(Collectors.toList());
        log.info("Found {} questions for test ID: {}", questions.size(), testId);
        if (questions.isEmpty()) {
            log.warn("No questions found for test ID: {}", testId);
        } else {
            questions.forEach(q -> log.debug("Question ID: {}, Text: {}", q.getQuestion_id(), q.getQuestionText()));
        }
        return questions;
    }
}
