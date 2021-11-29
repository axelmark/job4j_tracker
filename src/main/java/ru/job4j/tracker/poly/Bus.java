package ru.job4j.tracker.poly;

public class Bus implements Transport {

    private int count;
    private int fuel;

    public Bus(int count, int fuel) {
        this.count = count;
        this.fuel = fuel;
    }

    @Override
    public void drive() {
    }

    @Override
    public void passenger(int count) {
    }

    @Override
    public int fill(int fuel) {
        return 0;
    }
}
