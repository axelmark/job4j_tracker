package ru.job4j.oop;

public class Transport {

    public static void main(String[] args) {
        Vehicle bus = new Bus();
        Vehicle train = new Train();
        Vehicle plain = new Plain();
        Vehicle[] vehicle = new Vehicle[]{bus, train, plain};
        for (Vehicle vel : vehicle) {
            vel.move();
            vel.speed();
        }
    }
}

