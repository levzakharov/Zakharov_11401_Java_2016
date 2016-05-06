package ru.kpfu.itis.lzakharov.barbershop.service;

import ru.kpfu.itis.lzakharov.barbershop.domain.model.Barber;
import ru.kpfu.itis.lzakharov.barbershop.domain.model.Client;
import ru.kpfu.itis.lzakharov.barbershop.domain.model.Record;

import java.util.Date;
import java.util.List;

public interface RecordService extends AbstractCrudService<Record> {
    List<Record> findByDateAndBarber(Date date, Barber barber);
    List<Record> findByClient(Client client);
    Long count();
}
