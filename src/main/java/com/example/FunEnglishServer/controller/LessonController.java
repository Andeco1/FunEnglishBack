package com.example.FunEnglishServer.controller;

import com.example.FunEnglishServer.dto.LessonResponseDTO;
import com.example.FunEnglishServer.service.LessonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/lessons")
public class LessonController {
    
    private final LessonService lessonService;
    
    @Autowired
    public LessonController(LessonService lessonService) {
        this.lessonService = lessonService;
    }
    
    @GetMapping
    public ResponseEntity<List<LessonResponseDTO>> getAllLessons() {
        return ResponseEntity.ok(lessonService.getAllLessons());
    }
}
