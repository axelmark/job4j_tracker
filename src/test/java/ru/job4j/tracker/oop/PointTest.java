package ru.job4j.tracker.oop;

import static org.hamcrest.Matchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

import org.junit.Test;

public class PointTest {

    @Test
    public void distance3d() {
        Point coor1 = new Point(1, 2, 3);
        Point coor2 = new Point(3, 4, 2);
        double rsl = coor1.distance3d(coor2);
        assertThat(rsl, is(3.0));
    }
}