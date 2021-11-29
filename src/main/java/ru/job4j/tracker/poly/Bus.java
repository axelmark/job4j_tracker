package ru.job4j.tracker.poly;

public class Bus implements Transport {

    @Override
    public void drive() {
        System.out.println("drive method.");
    }

    @Override
    public void passenger(int count) {
        System.out.println("passanger " + count);
    }

    @Override
    public int fill(int fuel) {
        return 0;
    }
}
