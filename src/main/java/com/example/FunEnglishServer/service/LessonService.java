package com.example.FunEnglishServer.service;

import com.example.FunEnglishServer.model.Lesson;
import com.example.FunEnglishServer.repository.LessonRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class LessonService {
    private final LessonRepository repository;

    @Transactional(readOnly = true)
    public List<Lesson> getAll(){
        return repository.findAll();
    }

    @Transactional(readOnly = true)
    public Lesson getById(Long id){
        return repository.findById(id).orElseThrow(() -> new IllegalArgumentException("Урок не найден "+id));
    }

}
