package ru.kpfu.itis.lzakharov.barbershop.domain.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import ru.kpfu.itis.lzakharov.barbershop.domain.model.Barbershop;

@Repository
public interface BarbershopRepository extends CrudRepository<Barbershop, Integer> {
}
