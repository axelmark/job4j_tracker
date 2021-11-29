package ru.job4j.tracker.oop;

public class Bus implements Vehicle {

    @Override
    public void move() {
        System.out.print("The " + getClass().getSimpleName() + " moves on highways. ");
    }

    @Override
    public void speed() {
        System.out.println("Approximate speed - 120km/h");

    }
}
