package ru.job4j.oop;
import org.assertj.core.data.Percentage;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.*;

public class TriangleTest {

    @Test
    public void semiPerimeter() {
        double rsl = Triangle.semiPerimeter(2.0, 3.0, 1.0);
        assertThat(rsl).isEqualTo(3.0);
    }

    @Test
    public void exist() {
        boolean rsl = Triangle.exist(2, 2, 1);
        assertThat(rsl).isTrue();
    }

    @Test
    public void area() {
        Point a = new Point(0, 0);
        Point b = new Point(4, 0);
        Point c = new Point(0, 4);
        Triangle triangle = new Triangle(a, b, c);
        double rsl = triangle.area();
        assertThat(rsl).isCloseTo(8, Percentage.withPercentage(0.001));
    }

    @Test
    public void areaNot() {
        Point a = new Point(2, 0);
        Point b = new Point(2, 0);
        Point c = new Point(2, 4);
        Triangle triangle = new Triangle(a, b, c);
        double rsl = triangle.area();
        assertThat(rsl).isEqualTo(-1.0);
    }
}