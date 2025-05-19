package com.example.FunEnglishServer.service;

import com.example.FunEnglishServer.model.Question;
import com.example.FunEnglishServer.model.UserProgress;
import com.example.FunEnglishServer.repository.UserProgressRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserProgressService {
    private final UserProgressRepository repository;
    @Transactional(readOnly = true)
    public List<UserProgress> getAll(){
        return repository.findAll();
    }

}
