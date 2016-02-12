/**
 * Created by lzakharov on 12.02.16.
 */
public class Motorcycle extends Machine {
    public Motorcycle(int speed, int fuel) {
        super(speed, fuel);
    }

    @Override
    public int accelerate() {
        speed = Math.max(120, speed + 20);
        System.out.println("RROOAAARR");
        return speed;
    }
}
