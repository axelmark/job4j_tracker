package ru.job4j.stream;

import static org.junit.Assert.assertEquals;

import java.util.Arrays;
import java.util.List;
import org.junit.Test;

public class MatrixToListTest {

    @Test
    public void whenInputSquareMatrix() {
        Integer[][] matrix = {
            {1, 2, 3},
            {4, 5, 6},
            {7, 8, 9}
        };
        List<Integer> result = MatrixToList.convert(matrix);
        List<Integer> expected = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9);
        assertEquals(expected, result);
    }

    @Test
    public void whenInputNoSquareMatrix() {
        Integer[][] matrix = {
            {1},
            {2, 3},
            {4, 5, 6}
        };
        List<Integer> result = MatrixToList.convert(matrix);
        List<Integer> expected = Arrays.asList(1, 2, 3, 4, 5, 6);
        assertEquals(expected, result);
    }
}