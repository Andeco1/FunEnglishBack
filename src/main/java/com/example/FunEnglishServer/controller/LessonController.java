package com.example.FunEnglishServer.controller;

import com.example.FunEnglishServer.model.Lesson;
import com.example.FunEnglishServer.service.LessonService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/lessons")
@RequiredArgsConstructor
public class LessonController {
    private final LessonService service;

    @GetMapping
    public ResponseEntity<List<Lesson>> getAll(){
        return ResponseEntity.ok(service.getAll());
    }

}
