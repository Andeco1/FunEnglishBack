package com.example.FunEnglishServer.controller;

import com.example.FunEnglishServer.model.Question;
import com.example.FunEnglishServer.model.Test;
import com.example.FunEnglishServer.service.QuestionService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("api/questions")
@RequiredArgsConstructor
public class QuestionController {
    private final QuestionService service;

    @GetMapping
    public ResponseEntity<List<Question>> getAll(){
        return ResponseEntity.ok(service.getAll());
    }
}
