/**
 * Created by lzakharov on 12.02.16.
 */
public class Rifle extends Weapon {
    public Rifle() {
        this.damage = 10;
        this.range = 100;
        this.cageSize = 10;
        this.numOfRoundsInCage = this.cageSize;
    }

    @Override
    public void shoot() {
        if (numOfRoundsInCage > 0) {
            System.out.println("Shoot a rifle!");
            numOfRoundsInCage--;
        }
    }

}
