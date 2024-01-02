package ru.job4j.ex;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.NoSuchElementException;

import static org.assertj.core.api.Assertions.*;

public class FactTest {

    @Test()
    public void calc() {
        IllegalArgumentException thrown = Assertions.assertThrows(IllegalArgumentException.class, () -> {
            Fact fact = new Fact();
            int rsl = fact.calc(-1);
        });
    }
}