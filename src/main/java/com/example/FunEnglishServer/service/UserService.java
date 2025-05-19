package com.example.FunEnglishServer.service;

import com.example.FunEnglishServer.model.User;
import com.example.FunEnglishServer.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.HashMap;

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

    public Map<String, Object> login(String username, String password) {
        Map<String, Object> resp = new HashMap<>();
        Optional<User> optUser = repository.findByLogin(username);
        if (optUser.isEmpty()) {
            resp.put("success", false);
            resp.put("message", "User not found.");
            return resp;
        }
        User user = optUser.get();
        if (!user.getPassword().equals(password)) {
            resp.put("success", false);
            resp.put("message", "Wrong password.");
            return resp;
        }
        resp.put("success", true);
        resp.put("token", "dummy_token_for_" + username);
        resp.put("user_id", Long.valueOf(user.getId()));
        return resp;
    }
}
