package ru.kpfu.itis.lzakharov.barbershop.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.kpfu.itis.lzakharov.barbershop.domain.model.Credential;
import ru.kpfu.itis.lzakharov.barbershop.domain.model.Role;

@Repository
public interface CredentialRepository extends JpaRepository<Credential, Integer> {
    Credential findOneByLogin(String login);
}
