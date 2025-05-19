package com.example.FunEnglishServer.controller;

import com.example.FunEnglishServer.model.User;
import com.example.FunEnglishServer.model.UserProgress;
import com.example.FunEnglishServer.service.UserProgressService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("api/usersprogress")
@RequiredArgsConstructor
public class UserProgressController {
    private final UserProgressService service;

    @GetMapping
    public ResponseEntity<List<UserProgress>> getAll(){
        return ResponseEntity.ok(service.getAll());
    }

}
