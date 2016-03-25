package ru.kpfu.itis.lzakharov.army;

/**
 * Created by lzakharov on 12.02.16.
 */
public class Tankman extends Soldier implements Driving, Shooting {
    Tank tank;

    public Tankman(String name, int x, int y, int health, String direction, int punchDamage, int kickDamage) {
        super(name, x, y, health, direction, punchDamage, kickDamage);
    }

    @Override
    public void getIn(Machine machine) {
        tank = (Tank) machine;
        machine.setOwner(this);
    }

    @Override
    public void getOut() {
        tank.setOwner(null);
        tank = null;
    }

    @Override
    public void pressGas() {
        tank.accelerate();
    }

    @Override
    public void applyBrakes() {
        tank.brake();
    }

    @Override
    public void turnSteeringWheel(float angle) {
        tank.turn(angle);
    }

    @Override
    public boolean shoot() {
        if (tank != null) {
            return tank.shoot();
        } else {
            return false;
        }
    }

    @Override
    public void aim() {
        if (tank != null) {
            tank.aim();
        }
    }

    @Override
    public void reload() {
        if (tank != null) {
            tank.reload();
        }
    }
}
