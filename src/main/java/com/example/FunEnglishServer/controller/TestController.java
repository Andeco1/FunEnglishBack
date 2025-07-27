package com.example.FunEnglishServer.controller;

import com.example.FunEnglishServer.model.Lesson;
import com.example.FunEnglishServer.model.Test;
import com.example.FunEnglishServer.service.TestService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("api/tests")
@RequiredArgsConstructor
public class TestController {
    private final TestService service;

    @GetMapping
    public ResponseEntity<List<Test>> getAll(){
        return ResponseEntity.ok(service.getAll());
    }

}
