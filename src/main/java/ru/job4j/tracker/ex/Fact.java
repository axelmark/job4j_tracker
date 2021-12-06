package ru.job4j.tracker.ex;

public class Fact {

    public static void main(String[] args) {
        new Fact().calc(-1);
    }

    public int calc(int n) {
        int rsl = 1;
        if (n < 0) {
            throw new IllegalArgumentException("Аргумент может равняться 0");
        }
        for (int index = 2; index <= n; index++) {
            rsl *= index;
        }
        return rsl;
    }
}
