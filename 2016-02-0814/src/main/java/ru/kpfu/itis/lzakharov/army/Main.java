package ru.kpfu.itis.lzakharov.army;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by lzakharov on 12.02.16.
 */
public class Main {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("spring-config.xml");

        Infantryman infantryman = (Infantryman) context.getBean("infantryman");

        infantryman.shoot();
        infantryman.aim();
        infantryman.reload();

        Medic medic = (Medic) context.getBean("medic");

        medic.shoot();
        medic.aim();
        medic.reload();
        medic.heal();
        medic.tie();
        medic.heal(infantryman);
        medic.tie(infantryman);

        Tankman tankman = (Tankman) context.getBean("tankman");
        Tank tank = (Tank) context.getBean("tank");

        tankman.getIn(tank);
        tankman.shoot();
        tankman.aim();
        tankman.reload();
        tankman.pressGas();
        tankman.applyBrakes();
        tankman.turnSteeringWheel(1);
        tankman.getOut();

        MotorcycleDriver driver = (MotorcycleDriver) context.getBean("motorcycle-driver");
        Motorcycle motorcycle = (Motorcycle) context.getBean("motorcycle");

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
