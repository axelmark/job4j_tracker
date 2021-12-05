package ru.job4j.tracker.ex;

public class Fact {

    public static void main(String[] args) {
        int n = -1;
        if (n < 0) {
            throw new IllegalArgumentException("Argument should be more than zero");
        }
        new Fact().calc(n);

    }

    public int calc(int n) {
        int rsl = 1;
        for (int index = 1; index <= n; index++) {
            rsl *= index;
        }
        return rsl;
    }
}
