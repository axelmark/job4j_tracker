package ru.job4j.tracker.poly;

public interface Transport {

    void drive();

    void passenger(int count);

    int fill(int fuel);
}
