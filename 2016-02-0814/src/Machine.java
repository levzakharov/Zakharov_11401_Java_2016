/**
 * Created by lzakharov on 12.02.16.
 */
public abstract class Machine implements Drivable {
    Soldier owner;
    int x, y;
    int speed;
    float angle;
    int fuel;

    public void setOwner(Soldier owner) {
        this.owner = owner;
    }

    public Machine(int speed, int fuel) {
        this.speed = speed;
        this.fuel = fuel;
    }

    public void brake() {
        System.out.println("Break!");
        speed = 0;
    }

    public float turn(float angle) {
        this.angle += angle;
        System.out.printf("Turn!");
        return this.angle;
    }
}
