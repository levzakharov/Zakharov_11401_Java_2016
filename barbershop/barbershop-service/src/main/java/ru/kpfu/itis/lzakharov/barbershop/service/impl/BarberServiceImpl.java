package ru.kpfu.itis.lzakharov.barbershop.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Service;
import ru.kpfu.itis.lzakharov.barbershop.domain.model.Barber;
import ru.kpfu.itis.lzakharov.barbershop.domain.model.Barbershop;
import ru.kpfu.itis.lzakharov.barbershop.domain.repository.BarberRepository;
import ru.kpfu.itis.lzakharov.barbershop.service.BarberService;

import java.util.List;

@Service
public class BarberServiceImpl implements BarberService {
    @Autowired
    private BarberRepository barberRepository;

    @Override
    public Barber save(Barber entity) {
        return barberRepository.save(entity);
    }

    @Override
    public Barber findOne(Integer id) {
        return barberRepository.findOne(id);
    }

    @Override
    public List<Barber> findAll() {
        return (List<Barber>) barberRepository.findAll();
    }

    @Override
    public void delete(Integer id) {
        Barber barber = barberRepository.findOne(id);

        if (barber == null) {
            // TODO: throw exception
        }

        barberRepository.delete(barber);
    }

    @Override
    public Barber update(Barber entity) {
        return barberRepository.save(entity);
    }
}
