package ru.kpfu.itis.lzakharov.army;

/**
 * Created by lzakharov on 12.02.16.
 */
public interface Driving {
    void getIn(Machine machine);
    void getOut();
    void pressGas();
    void applyBrakes();
    void turnSteeringWheel(float angle);
}
