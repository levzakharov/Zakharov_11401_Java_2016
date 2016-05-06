package ru.kpfu.itis.lzakharov.barbershop.service;

import ru.kpfu.itis.lzakharov.barbershop.domain.model.Credential;

public interface CredentialService {
    Credential findOneByLogin(String login);
    Credential save(Credential credential);
    Long count();
}
