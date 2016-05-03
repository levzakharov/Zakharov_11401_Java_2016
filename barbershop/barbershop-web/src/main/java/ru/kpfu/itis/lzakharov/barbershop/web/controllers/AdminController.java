package ru.kpfu.itis.lzakharov.barbershop.web.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import ru.kpfu.itis.lzakharov.barbershop.domain.model.Barber;
import ru.kpfu.itis.lzakharov.barbershop.forms.AttendanceForm;
import ru.kpfu.itis.lzakharov.barbershop.forms.BarberForm;
import ru.kpfu.itis.lzakharov.barbershop.forms.BarberUpdateInfoForm;
import ru.kpfu.itis.lzakharov.barbershop.forms.BarbershopForm;
import ru.kpfu.itis.lzakharov.barbershop.service.AttendanceService;
import ru.kpfu.itis.lzakharov.barbershop.service.BarberService;
import ru.kpfu.itis.lzakharov.barbershop.service.BarbershopService;

import javax.jws.WebParam;
import javax.validation.Valid;
import java.util.Date;
import java.util.LinkedList;

@Controller
@RequestMapping(value = "/admin")
public class AdminController {
    @Autowired
    BarberService barberService;

    @Autowired
    BarbershopService barbershopService;

    @Autowired
    AttendanceService attendanceService;

    @RequestMapping(value = "")
    public String getIndex() {
        return "admin";
    }

    @RequestMapping(value = "/barbers", method = RequestMethod.GET)
    public String getBarbers(ModelMap model) {
        model.addAttribute("barber-form", new BarberForm());
        model.put("barbers", barberService.findAll());

        return "barbers";
    }

    @RequestMapping(value = "/barbers", method = RequestMethod.POST)
    public String addBarber(@ModelAttribute("barber-form") @Valid BarberForm barberForm, BindingResult result,
                            ModelMap model) {

        if (result.hasErrors()) {
            model.put("barbers", barberService.findAll());
            return "barbers";
        } else {
            barberService.save(barberForm.toBarber());
        }

        return "redirect:/admin/barbers";
    }

    @RequestMapping(value = "/barbers/delete/{id}", method = RequestMethod.GET)
    public ModelAndView removeBarber(@PathVariable Integer id) {
        barberService.delete(id);

        return new ModelAndView("redirect:/admin/barbers");
    }

    @RequestMapping(value = "/barbershops", method = RequestMethod.GET)
    public String getBarbershops(ModelMap model) {
        model.addAttribute("barbershop-form", new BarbershopForm());
        model.put("barbershops", barbershopService.findAll());

        return "barbershops";
    }

    @RequestMapping(value = "/barbershops", method = RequestMethod.POST)
    public String addBarbershop(@ModelAttribute("barbershop-form") @Valid BarbershopForm barbershopForm,
                                BindingResult result, ModelMap model) {

        if (result.hasErrors()) {
            model.put("barbershops", barbershopService.findAll());
            return "barbershops";
        } else {
            barbershopService.save(barbershopForm.toBarbershop());
        }

        return "redirect:/admin/barbershops";
    }

    @RequestMapping(value = "/barbershops/delete/{id}", method = RequestMethod.GET)
    public ModelAndView removeBarbershop(@PathVariable Integer id) {
        barbershopService.delete(id);

        return new ModelAndView("redirect:/admin/barbershops");
    }

    @RequestMapping(value = "/barbers/{id}", method = RequestMethod.GET)
    public String getBarber(@PathVariable Integer id, ModelMap model) {
        model.put("barber-form", new BarberForm());
        model.put("barber", barberService.findOne(id));
        model.put("barbershops", barbershopService.findAll());

        return "barber";
    }

    @RequestMapping(value = "/barbers/{id}", method = RequestMethod.POST)
    public String updateBarberInfo(@ModelAttribute("barber-form") @Valid BarberUpdateInfoForm barberForm,
                                   BindingResult result, @PathVariable Integer id, ModelMap model) {

        Barber barber = barberService.findOne(id);

        if (result.hasErrors()) {
            model.put("barber", barber);
            model.put("barbershops", barbershopService.findAll());

            return "barber";
        } else {
            barberForm.updateBarber(barber);
            barberService.update(barber);
        }

        return "redirect:/admin/barbers/" + id;
    }

    @RequestMapping(value = "/barbers/{id}/barbershop", method = RequestMethod.POST)
    public String setBarbershopToBarber(@PathVariable Integer id, @RequestParam("barbershop-id") Integer barbershopId) {

        Barber barber = barberService.findOne(id);
        barber.setBarbershop(barbershopService.findOne(barbershopId));
        barberService.update(barber);

        return "redirect:/admin/barbers/" + id;
    }

    @RequestMapping(value = "/attendances", method = RequestMethod.GET)
    public String getAttendances(ModelMap model) {
        model.put("attendance-form", new AttendanceForm());
        model.put("attendances", attendanceService.findAll());

        return "attendances";
    }

    @RequestMapping(value = "/attendances", method = RequestMethod.POST)
    public String addAttendance(@ModelAttribute("attendance-form") @Valid AttendanceForm attendanceForm,
                                BindingResult result, ModelMap model) {

        if (result.hasErrors()) {
            model.put("attendances", attendanceService.findAll());
            return "attendances";
        } else {
            attendanceService.save(attendanceForm.toAttendance());
        }

        return "redirect:/admin/attendances";

    }

    @RequestMapping(value = "/attendances/delete/{id}", method = RequestMethod.GET)
    public ModelAndView removeAttendance(@PathVariable Integer id) {
        attendanceService.delete(id);

        return new ModelAndView("redirect:/admin/attendances");
    }

}
