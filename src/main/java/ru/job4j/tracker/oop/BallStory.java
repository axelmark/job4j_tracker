package ru.job4j.tracker.oop;

public class BallStory {

    public static void main(String[] args) {
        Ball ball = new Ball();
        Hare hare = new Hare();
        hare.tryEat(ball);
        Fox fox = new Fox();
        fox.tryEat(ball);
        Wolf wolf = new Wolf();
        wolf.tryEat(ball);
    }
}
