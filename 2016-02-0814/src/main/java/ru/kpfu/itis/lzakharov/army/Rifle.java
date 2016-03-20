package ru.kpfu.itis.lzakharov.army;

/**
 * Created by lzakharov on 12.02.16.
 */
public class Rifle extends Weapon {
    public Rifle(Soldier owner) {
        super(owner, 10, 100, 10, 10);
    }

    @Override
    public void shoot() {
        if (numOfRoundsInCage > 0) {
            System.out.println("Shoot a rifle!");
            numOfRoundsInCage--;
        }
    }

}
