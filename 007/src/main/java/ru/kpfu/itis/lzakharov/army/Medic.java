package ru.kpfu.itis.lzakharov.army;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import java.util.Random;

/**
 * Created by lzakharov on 12.02.16.
 */
public class Medic extends Soldier implements Healing, Shooting{
    @Autowired
    @Qualifier("pistol")
    Shootable pistol;
    public boolean isAim;

    public Medic(String name, int x, int y, int health, String direction, int punchDamage, int kickDamage) {
        super(name, x, y, health, direction, punchDamage, kickDamage);
    }

    @Override
    public void heal() {
        heal(this);
    }

    @Override
    public void tie() {
        tie(this);
    }

    @Override
    public void heal(Soldier soldier) {
        System.out.println("Heal " + soldier.name);
        soldier.health = Math.max(100, soldier.health + 10);
    }

    @Override
    public void tie(Soldier soldier) {
        System.out.println("Tie " + soldier.name);
        soldier.health = Math.max(100, soldier.health + 5);
    }

    @Override
    public boolean shoot() {
        Random random = new Random();

        if (random.nextFloat() > (isAim ? 0.6 : 0.5)) {
            pistol.shoot();
            System.out.println("Caused damage!");
            return true;
        } else {
            System.out.println("Missed!");
            return false;
        }
    }

    @Override
    public void aim() {
        pistol.aim();
        isAim = !isAim;
    }

    @Override
    public void reload() {
        pistol.reload();
    }
}
