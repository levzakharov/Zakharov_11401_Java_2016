package ru.kpfu.itis.lzakharov.barbershop.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.kpfu.itis.lzakharov.barbershop.domain.model.Admin;
import ru.kpfu.itis.lzakharov.barbershop.domain.model.Credential;

@Repository
public interface AdminRepository extends JpaRepository<Admin, Integer> {
    Admin findOneByCredential(Credential credential);
}
