package ru.kpfu.itis.lzakharov.army;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

@Configuration
@ComponentScan("ru.kpfu.itis.lzakharov.army")
public class Config {
    @Bean
    public Infantryman infantryman() {
        return new Infantryman("A", 0, 0, 100, "NORTH", 2, 3);
    }

    @Bean
    public Medic medic() {
        return new Medic("B", 1, 1, 200, "NORTH", 2, 2);
    }

    @Bean
    public Tankman tankman() {
        return new Tankman("C", 2, 2, 100, "EAST", 2, 4);
    }

    @Bean
    public Tank tank() {
        return new Tank(10, 200);
    }

    @Bean
    public MotorcycleDriver motorcycleDriver() {
        return new MotorcycleDriver("D", 3, 3, 100, "WEST", 3, 2);
    }

    @Bean
    public Motorcycle motorcycle() {
        return new Motorcycle(20, 100);
    }
}
