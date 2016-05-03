package ru.kpfu.itis.lzakharov.barbershop.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.kpfu.itis.lzakharov.barbershop.domain.model.Attendance;
import ru.kpfu.itis.lzakharov.barbershop.domain.repository.AttendanceRepository;
import ru.kpfu.itis.lzakharov.barbershop.service.AttendanceService;

import java.util.List;

@Service
public class AttendanceServiceImpl implements AttendanceService {
    @Autowired
    AttendanceRepository attendanceRepository;

    @Override
    public Attendance save(Attendance entity) {
        return attendanceRepository.save(entity);
    }

    @Override
    public Attendance findOne(Integer id) {
        return attendanceRepository.findOne(id);
    }

    @Override
    public List<Attendance> findAll() {
        return (List<Attendance>) attendanceRepository.findAll();
    }

    @Override
    public void delete(Integer id) {
        Attendance attendance = attendanceRepository.findOne(id);

        if (attendance == null) {
            // TODO: throw exception
        }

        attendanceRepository.delete(attendance);
    }

    @Override
    public Attendance update(Attendance entity) {
        return attendanceRepository.save(entity);
    }
}
