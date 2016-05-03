package ru.kpfu.itis.lzakharov.barbershop.domain.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import ru.kpfu.itis.lzakharov.barbershop.domain.model.Barber;

/**
 * This repository provides operations for {@link ru.kpfu.itis.lzakharov.barbershop.domain.model.Barber}.
 *
 */

@Repository
public interface BarberRepository extends CrudRepository<Barber, Integer> {
}
