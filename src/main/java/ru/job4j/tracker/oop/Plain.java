package ru.job4j.tracker.oop;

public class Plain implements Vehicle {

    @Override
    public void move() {
        System.out.print("The " + getClass().getSimpleName() + " flies through the air. ");
    }

    @Override
    public void speed() {
        System.out.println("Approximate speed - 1000km/h.");
    }
}
