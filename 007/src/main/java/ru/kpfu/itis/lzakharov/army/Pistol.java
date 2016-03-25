package ru.kpfu.itis.lzakharov.army;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

/**
 * Created by lzakharov on 12.02.16.
 */
@Component("pistol")
@Scope("prototype")
public class Pistol extends Weapon{
    public Pistol() {
        super(5, 50, 12, 12);
    }

    @Override
    public void shoot() {
        if (numOfRoundsInCage > 0) {
            System.out.println("Shoot a pistol!");
            numOfRoundsInCage--;
        }
    }
}
