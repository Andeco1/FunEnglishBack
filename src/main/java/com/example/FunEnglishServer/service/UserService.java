
package com.example.FunEnglishServer.service;

import com.example.FunEnglishServer.model.User;
import com.example.FunEnglishServer.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;

@Service
@RequiredArgsConstructor
public class UserService implements UserDetailsService {
    private static final Logger log = LoggerFactory.getLogger(UserService.class);
    private final UserRepository repository;
    private final PasswordEncoder passwordEncoder;

    @Transactional(readOnly = true)
    public List<User> getAll(){
        return repository.findAll();
    }

    @Transactional(readOnly = true)
    public User getByLogin(String login){
        return repository.findByLogin(login).orElse(null);
    }

    public Map<String, Object> login(String username, String rawPassword) {
        Map<String, Object> resp = new HashMap<>();
        Optional<User> optUser = repository.findByLogin(username);

        if (optUser.isEmpty()) {
            resp.put("success", false);
            resp.put("message", "User not found.");
            return resp;
        }
        User user = optUser.get();
        // Проверка пароля через PasswordEncoder
        if (!passwordEncoder.matches(rawPassword, user.getPassword())) {
            resp.put("success", false);
            resp.put("message", "Wrong password.");
            return resp;
        }
        // Здесь можно сгенерировать реальный JWT-токен
        resp.put("success", true);
        resp.put("token", "dummy_token_for_" + username);
        resp.put("user_id", user.getId());
        return resp;
    }

    public Map<String,  Object> register(String username, String password){
        Map<String, Object> resp = new HashMap<>();
        Optional<User> optUser = repository.findByLogin(username);
        if (optUser.isEmpty()) {

            ///register the user
            resp.put("success", true);
            resp.put("message", "User not found.");
            log.info(password+ passwordEncoder.encode(password));
            password = passwordEncoder.encode(password);
            repository.save(new User(username,password));
        }else{
            resp.put("success",false);
            resp.put("message","User already exists");
        }
        return resp;
    }
    @Override
    public UserDetails loadUserByUsername(String login) throws UsernameNotFoundException {
        User user = repository.findByLogin(login)
                .orElseThrow(() -> new UsernameNotFoundException("User not found: " + login));

        return new org.springframework.security.core.userdetails.User(
                user.getLogin(),
                user.getPassword(),
                Collections.emptyList()
        );
    }
}
