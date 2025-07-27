package com.example.FunEnglishServer.controller;

import com.example.FunEnglishServer.dto.QuestionResponse;
import com.example.FunEnglishServer.model.Question;
import com.example.FunEnglishServer.model.Test;
import com.example.FunEnglishServer.service.QuestionService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/questions")
@RequiredArgsConstructor
@Slf4j
public class QuestionController {
    private final QuestionService service;

    @GetMapping
    public ResponseEntity<List<QuestionResponse>> getAll(){
        return ResponseEntity.ok(service.getAll());
    }

    @GetMapping("/test/{testId}")
    public ResponseEntity<List<QuestionResponse>> getByTestId(@PathVariable Long testId) {
        List<QuestionResponse> questions = service.getByTestId(testId);
        if (questions.isEmpty()) {
            log.warn("No questions found for test ID: {}", testId);
            return ResponseEntity.ok(List.of()); // Return empty list instead of 404
        }
        return ResponseEntity.ok(questions);
    }
}
