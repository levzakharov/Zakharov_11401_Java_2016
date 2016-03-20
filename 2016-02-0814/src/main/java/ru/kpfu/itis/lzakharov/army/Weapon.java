package ru.kpfu.itis.lzakharov.army;

/**
 * Created by lzakharov on 12.02.16.
 */
public abstract class Weapon implements Shootable {
    public Soldier owner;
    public int damage;
    public int range;
    public int cageSize;
    public int numOfRoundsInCage;

    public Weapon(Soldier owner, int damage, int range, int cageSize, int numOfRoundsInCage) {
        this.owner = owner;
        this.damage = damage;
        this.range = range;
        this.cageSize = cageSize;
        this.numOfRoundsInCage = numOfRoundsInCage;
    }

    @Override
    public void shoot() {
        if (numOfRoundsInCage > 0) {
            System.out.println("Shoot!");
            numOfRoundsInCage--;
        }
    }

    @Override
    public void aim() {
        System.out.println("Aim!");
    }

    @Override
    public void reload() {
        numOfRoundsInCage = cageSize;
        System.out.println("Reload!");
    }
}
