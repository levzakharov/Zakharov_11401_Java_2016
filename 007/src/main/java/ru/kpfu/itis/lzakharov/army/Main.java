package ru.kpfu.itis.lzakharov.army;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.LinkedList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        ApplicationContext context = new AnnotationConfigApplicationContext(Config.class);

        Infantryman infantryman = context.getBean(Infantryman.class);

        infantryman.shoot();
        infantryman.aim();
        infantryman.reload();

        Medic medic = context.getBean(Medic.class);

        medic.shoot();
        medic.aim();
        medic.reload();
        medic.heal();
        medic.tie();
        medic.heal(infantryman);
        medic.tie(infantryman);

        Tankman tankman = context.getBean(Tankman.class);
        Tank tank = context.getBean(Tank.class);

        tankman.getIn(tank);
        tankman.shoot();
        tankman.aim();
        tankman.reload();
        tankman.pressGas();
        tankman.applyBrakes();
        tankman.turnSteeringWheel(1);
        tankman.getOut();

        MotorcycleDriver driver = context.getBean(MotorcycleDriver.class);
        Motorcycle motorcycle = context.getBean(Motorcycle.class);

        driver.getIn(motorcycle);
        driver.pressGas();
        driver.applyBrakes();
        driver.turnSteeringWheel(1);
        driver.getOut();

        List<Soldier> soldiers = new LinkedList<Soldier>();
        soldiers.add(infantryman);
        soldiers.add(medic);
        soldiers.add(tankman);
        soldiers.add(driver);

        for (Soldier soldier: soldiers) {
            soldier.kick(infantryman);
            soldier.dodge();
            soldier.punch(infantryman);
            soldier.turnLeft();
            soldier.turnRight();
            soldier.walk();
        }
    }
}
