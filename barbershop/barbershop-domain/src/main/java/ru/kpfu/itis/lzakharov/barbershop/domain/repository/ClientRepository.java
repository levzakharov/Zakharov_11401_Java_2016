package ru.kpfu.itis.lzakharov.barbershop.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.kpfu.itis.lzakharov.barbershop.domain.model.Client;
import ru.kpfu.itis.lzakharov.barbershop.domain.model.Credential;

@Repository
public interface ClientRepository extends JpaRepository<Client, Integer> {
    Client findOneByCredential(Credential credential);
}
