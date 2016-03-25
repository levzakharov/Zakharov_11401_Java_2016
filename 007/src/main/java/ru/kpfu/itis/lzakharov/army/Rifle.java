package ru.kpfu.itis.lzakharov.army;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

/**
 * Created by lzakharov on 12.02.16.
 */
@Component("rifle")
@Scope("prototype")
public class Rifle extends Weapon {
    public Rifle() {
        super(10, 100, 10, 10);
    }

    @Override
    public void shoot() {
        if (numOfRoundsInCage > 0) {
            System.out.println("Shoot a rifle!");
            numOfRoundsInCage--;
        }
    }

}
