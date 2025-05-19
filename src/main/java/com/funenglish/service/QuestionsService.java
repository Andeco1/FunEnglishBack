package com.funenglish.service;

import com.funenglish.model.Questions;
import com.funenglish.repository.QuestionsRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class QuestionsService {
    private final QuestionsRepository repo;

    @Transactional(readOnly = true)
    public List<Questions> getAll() {
        return repo.findAll();
    }

    @Transactional(readOnly = true)
    public Questions getById(Long id) {
        return repo.findById(id).orElseThrow(() -> new IllegalArgumentException("Book not found: " + id));
    }


    @Transactional
    public Questions create(Questions questions) {
        return repo.save(questions);
    }

    @Transactional
    public List<Questions> createAll(List<Questions> q) {
        return repo.saveAll(q);
    }


    @Transactional
    public void delete(Long id) {
        repo.deleteById(id);
    }
}