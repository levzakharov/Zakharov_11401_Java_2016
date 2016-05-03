package ru.kpfu.itis.lzakharov.barbershop.domain;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import ru.kpfu.itis.lzakharov.barbershop.domain.config.PersistenceContext;
import ru.kpfu.itis.lzakharov.barbershop.domain.model.Barber;
import ru.kpfu.itis.lzakharov.barbershop.domain.model.Barbershop;
import ru.kpfu.itis.lzakharov.barbershop.domain.model.Gender;
import ru.kpfu.itis.lzakharov.barbershop.domain.repository.AttendanceRepository;
import ru.kpfu.itis.lzakharov.barbershop.domain.repository.BarberRepository;
import ru.kpfu.itis.lzakharov.barbershop.domain.repository.BarbershopRepository;

import java.util.Date;

public class Test {
    public static void main(String[] args) {
        ApplicationContext context = new AnnotationConfigApplicationContext(PersistenceContext.class);

        BarberRepository barberRepository = context.getBean(BarberRepository.class);
        BarbershopRepository barbershopRepository = context.getBean(BarbershopRepository.class);
        AttendanceRepository attendanceRepository = context.getBean(AttendanceRepository.class);

        System.out.println(attendanceRepository.findAll());

    }
}
