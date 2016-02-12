import java.util.Random;

/**
 * Created by lzakharov on 12.02.16.
 */
public class Infantryman extends Soldier implements Shooting{
    Shootable weapon;
    boolean isAim = false;

    @Override
    public void kick() {
        System.out.println();
    }

    @Override
    public boolean shoot() {
        Random random = new Random();

        if (random.nextFloat() > (isAim ? 0.7 : 0.5)) {
            weapon.shoot();
            System.out.println("Caused damage!");
            return true;
        } else {
            System.out.println("Missed!");
            return false;
        }
    }

    @Override
    public void aim() {
        isAim = true;
    }

    @Override
    public void reload() {
        weapon.reload();
    }

}
