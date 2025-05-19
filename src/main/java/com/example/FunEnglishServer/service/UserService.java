package com.example.FunEnglishServer.service;

import com.example.FunEnglishServer.model.User;
import com.example.FunEnglishServer.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepository repository;

    @Transactional(readOnly = true)
    public List<User> getAll(){
        return repository.findAll();
    }

    @Transactional(readOnly = true)
    public User getByLogin(String login){
        return repository.findByLogin(login).orElseThrow(() -> new IllegalArgumentException("Не найден пользователь "+login));
    }
}
