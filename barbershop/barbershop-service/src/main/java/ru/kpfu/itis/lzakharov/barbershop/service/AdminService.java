package ru.kpfu.itis.lzakharov.barbershop.service;

import ru.kpfu.itis.lzakharov.barbershop.domain.model.Admin;
import ru.kpfu.itis.lzakharov.barbershop.domain.model.Credential;

public interface AdminService {
    Admin findOneByCredential(Credential credential);
    Long count();
}
