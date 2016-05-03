package ru.kpfu.itis.lzakharov.barbershop.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.kpfu.itis.lzakharov.barbershop.domain.model.Barbershop;
import ru.kpfu.itis.lzakharov.barbershop.domain.repository.BarbershopRepository;
import ru.kpfu.itis.lzakharov.barbershop.service.BarbershopService;

import java.util.List;

@Service
public class BarbershopServiceImpl implements BarbershopService {
    @Autowired
    BarbershopRepository barbershopRepository;

    @Override
    public Barbershop save(Barbershop entity) {
        return barbershopRepository.save(entity);
    }

    @Override
    public Barbershop findOne(Integer id) {
        return barbershopRepository.findOne(id);
    }

    @Override
    public List<Barbershop> findAll() {
        return (List<Barbershop>) barbershopRepository.findAll();
    }

    @Override
    public void delete(Integer id) {
        Barbershop barbershop = barbershopRepository.findOne(id);

        if (barbershop == null) {
            // TODO: throw exception
        }

        barbershopRepository.delete(barbershop);
    }

    @Override
    public Barbershop update(Barbershop entity) {
        return barbershopRepository.save(entity);
    }
}
