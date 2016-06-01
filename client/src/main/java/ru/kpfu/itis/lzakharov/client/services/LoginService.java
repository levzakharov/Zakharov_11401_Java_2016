package ru.kpfu.itis.lzakharov.client.services;

import org.springframework.http.ResponseEntity;

public interface LoginService {
    ResponseEntity<Boolean> signIn(String login, String password);
}
