package ru.kpfu.itis.lzakharov.client.services.impl;

import org.springframework.http.ResponseEntity;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;
import ru.kpfu.itis.lzakharov.client.services.LoginService;
import ru.kpfu.itis.lzakharov.client.web.WebLinks;

public class LoginServiceImpl implements LoginService {
    RestTemplate restTemplate = new RestTemplate();

    @Override
    public ResponseEntity<Boolean> signIn(String login, String password) {
        MultiValueMap<String, Object> params = new LinkedMultiValueMap<>();

        params.add("login", login);
        params.add("password", password);

        return restTemplate.postForEntity(WebLinks.SIGN_IN, params, Boolean.class);
    }
}
