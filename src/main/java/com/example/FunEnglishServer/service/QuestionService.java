package com.example.FunEnglishServer.service;

import com.example.FunEnglishServer.model.Lesson;
import com.example.FunEnglishServer.model.Question;
import com.example.FunEnglishServer.repository.QustionRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class QuestionService {
    private final QustionRepository repository;

    @Transactional(readOnly = true)
    public List<Question> getAll(){
        return repository.findAll();
    }

}
