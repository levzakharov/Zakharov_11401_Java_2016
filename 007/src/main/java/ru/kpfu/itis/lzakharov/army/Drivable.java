package ru.kpfu.itis.lzakharov.army;

/**
 * Created by lzakharov on 12.02.16.
 */
public interface Drivable {
    int accelerate();
    void brake();
    float turn(float angle);
}
