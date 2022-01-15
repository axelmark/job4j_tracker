package ru.job4j.oop;

public class Train implements Vehicle {

    @Override
    public void move() {
        System.out.print("The " + getClass().getSimpleName() + " moves on rails. ");
    }

    @Override
    public void speed() {
        System.out.println("Approximate speed - 400km/h.");
    }
}
