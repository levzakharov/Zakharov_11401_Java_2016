package ru.kpfu.itis.lzakharov.barbershop.web.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import ru.kpfu.itis.lzakharov.barbershop.domain.model.*;
import ru.kpfu.itis.lzakharov.barbershop.service.*;
import ru.kpfu.itis.lzakharov.barbershop.web.security.SecurityUtils;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;

@Controller
@RequestMapping(value = "/client")
public class ClientController {
    @Autowired
    CredentialService credentialService;

    @Autowired
    BarbershopService barbershopService;

    @Autowired
    BarberService barberService;

    @Autowired
    AttendanceService attendanceService;

    @Autowired
    ClientService clientService;

    @Autowired
    RecordService recordService;

    @ModelAttribute("user")
    public Client credential() {
        return clientService.findOneByCredential(SecurityUtils.getCurrentUser());
    }


    @RequestMapping(value = "", method = RequestMethod.GET)
    public String index(ModelMap model) {
        model.put("barbershops", barbershopService.findAll());
        model.put("attendances", attendanceService.findAll());

        return "client";
    }

    @RequestMapping(value = "", method = RequestMethod.POST)
    public String createRecord(@RequestParam("barber_id") Integer barberId,
                               @RequestParam("attendance_id") Integer attendanceId,
                               @RequestParam("rdate") String rDate,
                               @RequestParam("hour") Integer hour) {

        Barber barber = barberService.findOne(barberId);
        Client client = clientService.findOneByCredential(SecurityUtils.getCurrentUser());
        Attendance attendance = attendanceService.findOne(attendanceId);

        Record record = new Record();
        record.setClient(client);
        record.setBarber(barber);
        record.setAttendance(attendance);
        record.setHour(hour);
        DateFormat format = new SimpleDateFormat("dd.MM.yyyy");
        try {
            Date date = format.parse(rDate);
            record.setDate(date);
        } catch (ParseException e) {
            e.printStackTrace();
        }

        recordService.save(record);

        return "redirect:/client/history";
    }

    @RequestMapping(value = "/history", method = RequestMethod.GET)
    public String getHistory(ModelMap model) {
        model.put("records", recordService.findByClient(credential()));

        return "history";
    }

    @RequestMapping(value = "/get_barbers", method = RequestMethod.POST)
    public @ResponseBody List<Barber> getBarbers(@RequestParam("barbershop_id") Integer barbershopId) {
        Barbershop barbershop = barbershopService.findOne(barbershopId);
        List<Barber> barbers = barberService.findByBarbershop(barbershop);
        return barbers;
    }

    @RequestMapping(value = "/get_time", method = RequestMethod.POST)
    public @ResponseBody List<Integer> getTime(@RequestParam("rdate") String rDate,
                                               @RequestParam("barber_id") Integer barberId) {

        List<Integer> time = new LinkedList<>();

        for (int i = 10; i < 21; i++) {
            time.add(i);
        }

        DateFormat format = new SimpleDateFormat("dd.MM.yyyy");
        try {
            Date date = format.parse(rDate);
            List<Record> records = recordService.findByDateAndBarber(date, barberService.findOne(barberId));
            for (Record record: records) {
                time.remove(record.getHour());
            }
        } catch (ParseException e) {
            e.printStackTrace();
        }


        return time;
    }
}
