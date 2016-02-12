import java.util.LinkedList;
import java.util.List;

/**
 * Created by lzakharov on 12.02.16.
 */
public class Main {
    public static void main(String[] args) {
        Infantryman infantryman = new Infantryman("A", 0, 0, 100, "NORTH", 2, 3);

        infantryman.shoot();
        infantryman.aim();
        infantryman.reload();

        Medic medic = new Medic("B", 1, 1, 100, "NORTH", 2, 2);

        medic.shoot();
        medic.aim();
        medic.reload();
        medic.heal();
        medic.tie();
        medic.heal(infantryman);
        medic.tie(infantryman);

        Tankman tankman = new Tankman("C", 2, 2, 100, "EAST", 2, 4);
        Tank tank = new Tank(10, 200);

        tankman.getIn(tank);
        tankman.shoot();
        tankman.aim();
        tankman.reload();
        tankman.pressGas();
        tankman.applyBrakes();
        tankman.turnSteeringWheel(1);
        tankman.getOut();

        MotorcycleDriver driver = new MotorcycleDriver("D", 3, 3, 100, "WEST", 3, 2);
        Motorcycle motorcycle = new Motorcycle(20, 100);

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
