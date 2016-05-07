package ru.kpfu.itis.lzakharov.barbershop.web.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import ru.kpfu.itis.lzakharov.barbershop.domain.model.Barber;
import ru.kpfu.itis.lzakharov.barbershop.domain.model.Client;
import ru.kpfu.itis.lzakharov.barbershop.domain.repository.RecordRepository;
import ru.kpfu.itis.lzakharov.barbershop.service.BarberService;
import ru.kpfu.itis.lzakharov.barbershop.web.security.SecurityUtils;

@Controller
@RequestMapping(value = "/barber")
public class BarberController {
    @Autowired
    BarberService barberService;

    @Autowired
    RecordRepository recordRepository;

    @ModelAttribute("user")
    public Barber credential() {
        return barberService.findOneByCredential(SecurityUtils.getCurrentUser());
    }
    @RequestMapping(value = "", method = RequestMethod.GET)
    public String index(ModelMap model) {
        model.put("records", recordRepository.findByBarber(credential()));

        return "main-barber";
    }
}
