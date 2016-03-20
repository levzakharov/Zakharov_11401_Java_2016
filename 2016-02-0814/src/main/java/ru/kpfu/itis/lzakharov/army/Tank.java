package ru.kpfu.itis.lzakharov.army;

import java.util.Random;

/**
 * Created by lzakharov on 12.02.16.
 */
public class Tank extends Machine implements Shooting{
    boolean isAim = false;
    boolean isReadyToShoot = true;

    public Tank(int speed, int fuel) {
        super(speed, fuel);
    }

    @Override
    public int accelerate() {
        speed = Math.max(60, speed + 10);
        return speed;
    }

    @Override
    public boolean shoot() {
        Random random = new Random();
        isReadyToShoot = false;

        if (random.nextFloat() > (isAim ? 0.8 : 0.1)) {
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
        isReadyToShoot = true;
    }
}
