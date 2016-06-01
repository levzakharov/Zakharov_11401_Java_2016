package ru.kpfu.itis.lzakharov.client;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import ru.kpfu.itis.lzakharov.client.controllers.LoginController;
import ru.kpfu.itis.lzakharov.client.javafx.SpringFXMLLoader;
import ru.kpfu.itis.lzakharov.client.javafx.ViewsLoader;
import ru.kpfu.itis.lzakharov.client.services.LoginService;
import ru.kpfu.itis.lzakharov.client.services.impl.LoginServiceImpl;

@Configuration
public class Config {

    @Bean
    LoginController loginController(){
        return new LoginController();
    }

    @Bean
    ViewsLoader viewsLoader(){
        return new ViewsLoader();
    }

    @Bean
    SpringFXMLLoader springFXMLLoader(){
        return new SpringFXMLLoader();
    }

    @Bean
    LoginService loginService() {
        return new LoginServiceImpl();
    }
}
