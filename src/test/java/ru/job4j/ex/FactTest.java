package ru.job4j.ex;

import org.junit.Test;

public class FactTest {

    @Test(expected = IllegalArgumentException.class)
    public void calc() {
        Fact fact = new Fact();
        int rsl = fact.calc(-1);
    }
}