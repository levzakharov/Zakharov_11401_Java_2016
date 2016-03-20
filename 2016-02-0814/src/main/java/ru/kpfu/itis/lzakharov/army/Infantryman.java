package ru.kpfu.itis.lzakharov.army;

import java.util.Random;

/**
 * Created by lzakharov on 12.02.16.
 */
public class Infantryman extends Soldier implements Shooting{
    Shootable rifle;
    boolean isAim = false;

    public Infantryman(String name, int x, int y, int health, String direction, int punchDamage, int kickDamage) {
        super(name, x, y, health, direction, punchDamage, kickDamage);
        rifle = new Rifle(this);
    }

    @Override
    public boolean shoot() {
        Random random = new Random();

        if (random.nextFloat() > (isAim ? 0.7 : 0.5)) {
            rifle.shoot();
            System.out.println("Caused damage!");
            return true;
        } else {
            System.out.println("Missed!");
            return false;
        }
    }

    @Override
    public void aim() {
        isAim = !isAim;
    }

    @Override
    public void reload() {
        rifle.reload();
    }
}
