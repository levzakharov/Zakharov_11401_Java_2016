/**
 * Created by lzakharov on 12.02.16.
 */
public interface Driving {
    void getIn(Drivable machine);
    void pressGas(Drivable machine);
    void applyBrakes(Drivable machine);
    void turnSteeringWheel(Drivable machine);
}
