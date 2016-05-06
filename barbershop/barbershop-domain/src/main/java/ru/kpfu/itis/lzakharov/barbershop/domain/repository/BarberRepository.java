package ru.kpfu.itis.lzakharov.barbershop.domain.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import ru.kpfu.itis.lzakharov.barbershop.domain.model.Barber;
import ru.kpfu.itis.lzakharov.barbershop.domain.model.Barbershop;
import ru.kpfu.itis.lzakharov.barbershop.domain.model.Credential;

import java.util.List;

@Repository
public interface BarberRepository extends CrudRepository<Barber, Integer> {
    List<Barber> findByBarbershop(Barbershop barbershop);
    Barber findOneByCredential(Credential credential);
}
