package ru.job4j.collection;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

import java.util.Arrays;
import org.junit.Test;

public class LexSortTest {

    @Test
    public void sortNum1and2and10() {
        String[] input = {
            "10. Task.",
            "1. Task.",
            "2. Task."
        };
        String[] out = {
            "1. Task.",
            "2. Task.",
            "10. Task."
        };
        Arrays.sort(input, new LexSort());
        assertThat(input, is(out));
    }
}