package ru.kpfu.itis.lzakharov.barbershop.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import ru.kpfu.itis.lzakharov.barbershop.domain.model.Barber;
import ru.kpfu.itis.lzakharov.barbershop.domain.model.Client;
import ru.kpfu.itis.lzakharov.barbershop.domain.model.Record;

import java.util.Date;
import java.util.List;

@Repository
public interface RecordRepository extends JpaRepository<Record, Integer> {
    List<Record> findByDateAndBarber(Date date, Barber barber);
    List<Record> findByClient(Client client);
    List<Record> findByBarber(Barber barber);
}
