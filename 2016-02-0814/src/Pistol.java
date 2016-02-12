/**
 * Created by lzakharov on 12.02.16.
 */
public class Pistol extends Weapon{
    public Pistol(Soldier owner) {
        super(owner, 5, 50, 12, 12);
    }

    @Override
    public void shoot() {
        if (numOfRoundsInCage > 0) {
            System.out.println("Shoot a pistol!");
            numOfRoundsInCage--;
        }
    }
}
