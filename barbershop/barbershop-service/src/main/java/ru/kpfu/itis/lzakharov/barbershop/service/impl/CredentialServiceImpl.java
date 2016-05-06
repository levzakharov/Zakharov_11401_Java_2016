package ru.kpfu.itis.lzakharov.barbershop.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.kpfu.itis.lzakharov.barbershop.domain.model.Credential;
import ru.kpfu.itis.lzakharov.barbershop.domain.repository.CredentialRepository;
import ru.kpfu.itis.lzakharov.barbershop.service.CredentialService;

@Service
public class CredentialServiceImpl implements CredentialService {
    @Autowired
    CredentialRepository credentialRepository;

    @Override
    public Credential findOneByLogin(String login) {
        return credentialRepository.findOneByLogin(login);
    }

    @Override
    public Credential save(Credential credential) {
        return credentialRepository.save(credential);
    }

    @Override
    public Long count() {
        return credentialRepository.count();
    }
}
