package ru.kpfu.itis.lzakharov.barbershop.web.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import ru.kpfu.itis.lzakharov.barbershop.domain.model.Client;
import ru.kpfu.itis.lzakharov.barbershop.domain.model.Credential;
import ru.kpfu.itis.lzakharov.barbershop.domain.model.Role;
import ru.kpfu.itis.lzakharov.barbershop.forms.ClientForm;
import ru.kpfu.itis.lzakharov.barbershop.service.ClientService;
import ru.kpfu.itis.lzakharov.barbershop.service.CredentialService;
import ru.kpfu.itis.lzakharov.barbershop.web.security.SecurityUtils;

import javax.validation.Valid;

@Controller
public class IndexController {
    @Autowired
    CredentialService credentialService;

    @Autowired
    ClientService clientService;

    @RequestMapping(value = "")
    public String getIndex() {
        return "redirect:/login";
    }

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String login() {

        return "login";
    }

    @RequestMapping(value = "/success-login", method = RequestMethod.GET)
    public String successLogin() {
        switch (SecurityUtils.getCurrentUser().getRole()) {
            case ROLE_ADMIN:
                return "redirect:/admin";
            case ROLE_CLIENT:
                return "redirect:/client";
            case ROLE_BARBER:
                return "redirect:/barber";
        }
        return "redirect:/";
    }

    @RequestMapping(value = "/registration", method = RequestMethod.GET)
    public String registration(ModelMap model) {
        model.put("registration-form", new ClientForm());

        return "registration";
    }

    @RequestMapping(value = "/registration", method = RequestMethod.POST)
    public String registration(@ModelAttribute("registration-form") @Valid ClientForm clientForm,
                               BindingResult result) {

        if (result.hasErrors()) {
            return "registration";
        } else {
            Credential credential = new Credential();
            credential.setLogin(clientForm.getLogin());
            credential.setPassword(clientForm.getPassword());
            credential.setRole(Role.ROLE_CLIENT);
            credential = credentialService.save(credential);

            Client client = new Client();
            client.setCredential(credential);
            client.setFirstName(clientForm.getFirstName());
            client.setLastName(clientForm.getLastName());
            client.setGender(clientForm.getGender());
            client.setBirthdate(clientForm.getBirthdate());

            clientService.save(client);

        }

        return "redirect:/";
    }
}
