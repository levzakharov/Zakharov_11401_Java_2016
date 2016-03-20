package ru.kpfu.itis.lzakharov.army;

/**
 * Created by lzakharov on 12.02.16.
 */
public interface Healing {
    void heal();
    void tie();
    void heal(Soldier soldier);
    void tie(Soldier soldier);
}
