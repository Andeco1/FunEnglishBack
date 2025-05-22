package com.example.FunEnglishServer.service;

import com.example.FunEnglishServer.dto.LessonResponseDTO;
import com.example.FunEnglishServer.model.Lesson;
import com.example.FunEnglishServer.repository.LessonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class LessonService {
    
    private final LessonRepository lessonRepository;
    
    @Autowired
    public LessonService(LessonRepository lessonRepository) {
        this.lessonRepository = lessonRepository;
    }
    
    @Transactional(readOnly = true)
    public List<Lesson> getAll(){
        return lessonRepository.findAll();
    }

    @Transactional(readOnly = true)
    public Lesson getById(Long id){
        return lessonRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Урок не найден "+id));
    }

    public List<LessonResponseDTO> getAllLessons() {
        return lessonRepository.findAll().stream()
                .map(lesson -> new LessonResponseDTO(
                    lesson.getLesson_id(),
                    lesson.getTitle(),
                    lesson.getContent(),
                    lesson.getLevel().getCode(),
                    lesson.getLevel().getDescription()
                ))
                .collect(Collectors.toList());
    }
}
