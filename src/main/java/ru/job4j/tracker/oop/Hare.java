package ru.job4j.tracker.oop;

public class Hare {

    Ball ball = new Ball();

    public void tryEat(Ball ball) {
        ball.tryRun(false);
    }
}
