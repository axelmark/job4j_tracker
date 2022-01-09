package ru.job4j.tracker.collection;


import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

import java.util.Arrays;
import org.junit.Test;

public class ConvertList2ArrayTest {

    @Test
    public void when7ElementsThen9() {
        int[][] result = ConvertList2Array.toArray(Arrays.asList(1, 2, 3, 4, 5, 6, 7), 3);
        int[][] expect = {
            {1, 2, 3},
            {4, 5, 6},
            {7, 0, 0}
        };
        assertThat(expect, is(result));
    }

    @Test
    public void when5ElementsThen6() {
        int[][] result = ConvertList2Array.toArray(
            Arrays.asList(1, 2, 3, 4, 5),
            2
        );
        int[][] expect = {
            {1, 2},
            {3, 4},
            {5, 0}
        };
        assertThat(result, is(expect));
    }
}