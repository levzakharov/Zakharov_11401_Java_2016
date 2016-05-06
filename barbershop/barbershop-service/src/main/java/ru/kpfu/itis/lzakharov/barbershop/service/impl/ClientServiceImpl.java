package ru.kpfu.itis.lzakharov.barbershop.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.kpfu.itis.lzakharov.barbershop.domain.model.Client;
import ru.kpfu.itis.lzakharov.barbershop.domain.model.Credential;
import ru.kpfu.itis.lzakharov.barbershop.domain.repository.ClientRepository;
import ru.kpfu.itis.lzakharov.barbershop.service.ClientService;

import java.util.List;

@Service
public class ClientServiceImpl implements ClientService {
    @Autowired
    ClientRepository clientRepository;

    @Override
    public Client save(Client entity) {
        return clientRepository.save(entity);
    }

    @Override
    public Client findOne(Integer id) {
        return clientRepository.findOne(id);
    }

    @Override
    public List<Client> findAll() {
        return clientRepository.findAll();
    }

    @Override
    public void delete(Integer id) {
        Client client = clientRepository.findOne(id);

        if (client == null) {
            // TODO: throw exception
        }

        clientRepository.delete(client);
    }

    @Override
    public Client update(Client entity) {
        return clientRepository.save(entity);
    }

    @Override
    public Client findOneByCredential(Credential credential) {
        return clientRepository.findOneByCredential(credential);
    }

    @Override
    public Long count() {
        return clientRepository.count();
    }
}
