package ru.kpfu.itis.lzakharov.barbershop.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.kpfu.itis.lzakharov.barbershop.domain.model.Admin;
import ru.kpfu.itis.lzakharov.barbershop.domain.model.Credential;
import ru.kpfu.itis.lzakharov.barbershop.domain.repository.AdminRepository;
import ru.kpfu.itis.lzakharov.barbershop.service.AdminService;

@Service
public class AdminServiceImpl implements AdminService {
    @Autowired
    AdminRepository adminRepository;

    @Override
    public Admin findOneByCredential(Credential credential) {
        return adminRepository.findOneByCredential(credential);
    }

    @Override
    public Long count() {
        return adminRepository.count();
    }
}
