package com.funenglish.service;

import com.funenglish.model.Lesson;
import com.funenglish.repository.LessonRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class LessonService {
    private final LessonRepository lessonRepository;

    @Transactional(readOnly = true)
    public List<Lesson> getAllLessons() {
        return lessonRepository.findAll();
    }

    @Transactional(readOnly = true)
    public List<Lesson> getLessonsByLevel(String level) {
        return lessonRepository.findByLevelOrderByOrderNumberAsc(level);
    }

    @Transactional
    public Lesson createLesson(Lesson lesson) {
        return lessonRepository.save(lesson);
    }

    @Transactional
    public Lesson updateLesson(Long id, Lesson lesson) {
        if (!lessonRepository.existsById(id)) {
            throw new RuntimeException("Lesson not found with id: " + id);
        }
        lesson.setId(id);
        return lessonRepository.save(lesson);
    }

    @Transactional
    public void deleteLesson(Long id) {
        lessonRepository.deleteById(id);
    }
} 