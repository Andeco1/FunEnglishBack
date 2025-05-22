package com.example.FunEnglishServer.service;

import com.example.FunEnglishServer.model.Question;
import com.example.FunEnglishServer.model.QuestionOption;
import com.example.FunEnglishServer.repository.QuestionOptionRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import jakarta.persistence.EntityNotFoundException;
import java.util.List;

@Service
@RequiredArgsConstructor
public class QuestionOptionService {
    private final QuestionOptionRepository repository;

    @Transactional(readOnly = true)
    public List<QuestionOption> getByQuestion(Question questionId) {
        return repository.findByQuestion(questionId);
    }

    @Transactional
    public QuestionOption create(QuestionOption option) {
        return repository.save(option);
    }

    @Transactional
    public List<QuestionOption> createAll(List<QuestionOption> options) {
        return repository.saveAll(options);
    }

    @Transactional
    public QuestionOption update(Long id, QuestionOption option) {
        if (!repository.existsById(id)) {
            throw new EntityNotFoundException("Question option not found with id: " + id);
        }
        option.setOption_id(id);
        return repository.save(option);
    }

    @Transactional
    public void delete(Long id) {
        if (!repository.existsById(id)) {
            throw new EntityNotFoundException("Question option not found with id: " + id);
        }
        repository.deleteById(id);
    }

} 