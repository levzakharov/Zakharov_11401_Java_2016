package ru.kpfu.itis.lzakharov.army;

/**
 * Created by lzakharov on 12.02.16.
 */
public interface Fighting {
    int punch(Soldier soldier);
    int kick(Soldier soldier);
    boolean dodge();
}
