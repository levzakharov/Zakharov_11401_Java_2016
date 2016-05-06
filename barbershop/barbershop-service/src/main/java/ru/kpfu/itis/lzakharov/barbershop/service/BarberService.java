package ru.kpfu.itis.lzakharov.barbershop.service;

import ru.kpfu.itis.lzakharov.barbershop.domain.model.Barber;
import ru.kpfu.itis.lzakharov.barbershop.domain.model.Barbershop;

import java.util.List;

public interface BarberService extends AbstractCrudService<Barber> {
    List<Barber> findByBarbershop(Barbershop barbershop);
    Long count();
}
