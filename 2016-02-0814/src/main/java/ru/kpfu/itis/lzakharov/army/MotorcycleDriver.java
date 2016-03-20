package ru.kpfu.itis.lzakharov.army;

import java.util.Random;

/**
 * Created by lzakharov on 12.02.16.
 */
public class MotorcycleDriver extends Soldier implements Driving, Shooting{
    Weapon submachineGun;
    boolean isAim;
    Motorcycle motorcycle;

    public MotorcycleDriver(String name, int x, int y, int health, String direction, int punchDamage, int kickDamage) {
        super(name, x, y, health, direction, punchDamage, kickDamage);
        submachineGun = new SubmachineGun(this);
    }

    @Override
    public void getIn(Machine machine) {
        motorcycle = (Motorcycle) machine;
        machine.setOwner(this);
    }

    @Override
    public void getOut() {
        motorcycle.setOwner(null);
        motorcycle = null;
    }

    @Override
    public void pressGas() {
        motorcycle.accelerate();
    }

    @Override
    public void applyBrakes() {
        motorcycle.brake();
    }

    @Override
    public void turnSteeringWheel(float angle) {
        motorcycle.turn(angle);
    }

    @Override
    public boolean shoot() {
        Random random = new Random();

        if (random.nextFloat() > (isAim ? 0.4 : 0.3)) {
            submachineGun.shoot();
            System.out.println("Caused damage!");
            return true;
        } else {
            System.out.println("Missed!");
            return false;
        }
    }

    @Override
    public void aim() {
        submachineGun.aim();
        isAim = !isAim;
    }

    @Override
    public void reload() {
        submachineGun.reload();
    }
}
