package com.example.FunEnglishServer.service;

import com.example.FunEnglishServer.model.Question;
import com.example.FunEnglishServer.model.Test;
import com.example.FunEnglishServer.model.User;
import com.example.FunEnglishServer.repository.QustionRepository;
import com.example.FunEnglishServer.repository.TestRepository;
import lombok.RequiredArgsConstructor;
import org.aspectj.weaver.patterns.TypePatternQuestions;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class TestService {
    private final TestRepository repository;

    @Transactional(readOnly = true)
    public List<Test> getAll(){
        return repository.findAll();
    }


}
