package ru.job4j.oop;

import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.*;

public class PointTest {

    @Test
    public void distance3d() {
        Point coor1 = new Point(1, 2, 3);
        Point coor2 = new Point(3, 4, 2);
        double rsl = coor1.distance3d(coor2);
        assertThat(rsl).isEqualTo(3.0);
    }
}