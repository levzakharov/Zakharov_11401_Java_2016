/**
 * Created by lzakharov on 12.02.16.
 */
public abstract class Soldier implements Movable, Fighting {
    public int x, y;
    public int health;
    public String direction;

    public void walk() {
        System.out.println("Walk!");
    }

    public void turnLeft() {
        System.out.println("Turn left!");
    }

    public void turnRight() {
        System.out.println("Turn right!");
    }

    public void punch() {
        System.out.println("Punch!");
    }

    public void kick() {
        System.out.println("Kick!");
    }

    public void dodge() {
        System.out.println("Dodge");
    }
}
