package ru.kpfu.itis.lzakharov.army;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

/**
 * Created by lzakharov on 12.02.16.
 */
@Component("submachine-gun")
@Scope("prototype")
public class SubmachineGun extends Weapon{
    public SubmachineGun() {
        super(8, 60, 40, 40);
    }

    @Override
    public void shoot() {
        if (numOfRoundsInCage > 0) {
            System.out.println("Shoot a submachine gun!");
            numOfRoundsInCage--;
        }
    }
}
