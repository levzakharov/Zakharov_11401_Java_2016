package ru.kpfu.itis.lzakharov.barbershop.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.kpfu.itis.lzakharov.barbershop.domain.model.Barber;
import ru.kpfu.itis.lzakharov.barbershop.domain.model.Client;
import ru.kpfu.itis.lzakharov.barbershop.domain.model.Record;
import ru.kpfu.itis.lzakharov.barbershop.domain.repository.RecordRepository;
import ru.kpfu.itis.lzakharov.barbershop.service.RecordService;

import java.util.Date;
import java.util.List;

@Service
public class RecordServiceImpl implements RecordService {
    @Autowired
    RecordRepository recordRepository;

    @Override
    public Record save(Record entity) {
        return recordRepository.save(entity);
    }

    @Override
    public Record findOne(Integer id) {
        return recordRepository.findOne(id);
    }

    @Override
    public List<Record> findAll() {
        return (List<Record>) recordRepository.findAll();
    }

    @Override
    public void delete(Integer id) {
        Record record = recordRepository.findOne(id);

        if (record == null) {
            // TODO: throw exception
        }

        recordRepository.delete(record);
    }

    @Override
    public Record update(Record entity) {
        return recordRepository.save(entity);
    }

    @Override
    public List<Record> findByDateAndBarber(Date date, Barber barber) {
        return recordRepository.findByDateAndBarber(date, barber);
    }

    @Override
    public List<Record> findByClient(Client client) {
        return recordRepository.findByClient(client);
    }

    @Override
    public List<Record> findByBarber(Barber barber) {
        return recordRepository.findByBarber(barber);
    }

    @Override
    public Long count() {
        return recordRepository.count();
    }
}
