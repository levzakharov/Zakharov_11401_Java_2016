import java.util.Random;

/**
 * Created by lzakharov on 12.02.16.
 */
public abstract class Soldier implements Movable, Fighting {
    String name;
    public int x, y;
    public int health;
    public String direction;
    public int punchDamage;
    public int kickDamage;

    public Soldier(String name, int x, int y, int health, String direction, int punchDamage, int kickDamage) {
        this.name = name;
        this.x = x;
        this.y = y;
        this.health = health;
        this.direction = direction;
        this.punchDamage = punchDamage;
        this.kickDamage = kickDamage;
    }

    public void walk() {
        System.out.println("Walk!");
    }

    public void turnLeft() {
        System.out.println("Turn left!");
    }

    public void turnRight() {
        System.out.println("Turn right!");
    }

    public int punch(Soldier soldier) {
        System.out.println("Punch!");
        return punchDamage;
    }

    public int kick(Soldier soldier) {
        System.out.println("Kick!");
        return kickDamage;
    }

    public boolean dodge() {
        Random random = new Random();
        if (random.nextFloat() > 0.5) {
            System.out.println("Dodge");
            return true;
        } else {
            return false;
        }
    }
}
