package ru.job4j.oop;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.closeTo;
import static org.hamcrest.Matchers.is;

import org.junit.Test;

public class TriangleTest {

    @Test
    public void semiPerimeter() {
        double rsl = Triangle.semiPerimeter(2.0, 3.0, 1.0);
        assertThat(rsl, is(3.0));
    }

    @Test
    public void exist() {
        boolean rsl = Triangle.exist(2, 2, 1);
        assertThat(rsl, is(true));
    }

    @Test
    public void area() {
        Point a = new Point(0, 0);
        Point b = new Point(4, 0);
        Point c = new Point(0, 4);
        Triangle triangle = new Triangle(a, b, c);
        double rsl = triangle.area();
        assertThat(rsl, closeTo(8, 0.001));
    }

    @Test
    public void areaNot() {
        Point a = new Point(2, 0);
        Point b = new Point(2, 0);
        Point c = new Point(2, 4);
        Triangle triangle = new Triangle(a, b, c);
        double rsl = triangle.area();
        assertThat(rsl, is(-1.0));
    }
}