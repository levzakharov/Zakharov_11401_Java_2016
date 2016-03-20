package ru.kpfu.itis.lzakharov.army;

/**
 * Created by lzakharov on 12.02.16.
 */
public class SubmachineGun extends Weapon{
    public SubmachineGun(Soldier owner) {
        super(owner, 8, 60, 40, 40);
    }

    @Override
    public void shoot() {
        if (numOfRoundsInCage > 0) {
            System.out.println("Shoot a submachine gun!");
            numOfRoundsInCage--;
        }
    }
}
