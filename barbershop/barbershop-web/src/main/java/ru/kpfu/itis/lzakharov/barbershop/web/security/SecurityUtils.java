package ru.kpfu.itis.lzakharov.barbershop.web.security;

import org.springframework.security.core.context.SecurityContextHolder;
import ru.kpfu.itis.lzakharov.barbershop.domain.model.Credential;

public class SecurityUtils {
    public static Credential getCurrentUser() {
        return (Credential) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
    }
}
