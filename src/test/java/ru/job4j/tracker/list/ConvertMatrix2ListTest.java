package ru.job4j.tracker.list;


import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

import java.util.Arrays;
import java.util.List;
import org.junit.Test;

public class ConvertMatrix2ListTest {

    @Test
    public void when2on2ArrayThenList4() {
        ConvertMatrix2List list = new ConvertMatrix2List();
        int[][] input = {
            {1, 2},
            {3, 4}
        };
        List<Integer> expect = Arrays.asList(
            1, 2, 3, 4
        );
        List<Integer> result = list.toList(input);
        assertThat(result, is(expect));
    }
}