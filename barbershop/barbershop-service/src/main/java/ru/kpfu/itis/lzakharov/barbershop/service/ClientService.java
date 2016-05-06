package ru.kpfu.itis.lzakharov.barbershop.service;

import ru.kpfu.itis.lzakharov.barbershop.domain.model.Client;
import ru.kpfu.itis.lzakharov.barbershop.domain.model.Credential;

public interface ClientService extends AbstractCrudService<Client> {
    Client findOneByCredential(Credential credential);
    Long count();
}
