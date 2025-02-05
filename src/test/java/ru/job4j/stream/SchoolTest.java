package ru.job4j.stream;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

public class SchoolTest {

    @Test
    public void whenCollectClassA() {
        List<Student> students = List.of(
                new Student(10, "Surname1"),
                new Student(40, "Surname4"),
                new Student(50, "Surname5"),
                new Student(70, "Surname7"),
                new Student(90, "Surname9")
        );
        School sc = new School();
        Predicate<Student> pr = x -> x.getScore() >= 70;
        Predicate<Student> pr2 = x -> x.getScore() <= 100;
        Predicate<Student> studentPredicate = pr.and(pr2);
        List<Student> rsl = sc.collect(students, studentPredicate);
        List<Student> expected = new ArrayList<>();
        expected.add(new Student(70, "Surname7"));
        expected.add(new Student(90, "Surname9"));
        assertThat(rsl).isEqualTo(expected);
    }

    @Test
    public void whenCollectClassB() {
        List<Student> students = List.of(
                new Student(20, "Surname2"),
                new Student(30, "Surname3"),
                new Student(50, "Surname5"),
                new Student(60, "Surname6"),
                new Student(80, "Surname8")
        );
        School sc = new School();
        Predicate<Student> pr = x -> x.getScore() >= 50;
        Predicate<Student> pr2 = x -> x.getScore() < 70;
        Predicate<Student> studentPredicate = pr.and(pr2);
        List<Student> rsl = sc.collect(students, studentPredicate);
        List<Student> expected = new ArrayList<>();
        expected.add(new Student(50, "Surname5"));
        expected.add(new Student(60, "Surname6"));
        assertThat(rsl).isEqualTo(expected);

    }

    @Test
    public void whenCollectClassV() {
        List<Student> students = List.of(
                new Student(10, "Surname1"),
                new Student(30, "Surname3"),
                new Student(40, "Surname4"),
                new Student(60, "Surname6"),
                new Student(90, "Surname9")
        );
        School sc = new School();
        Predicate<Student> pr = x -> x.getScore() > 0;
        Predicate<Student> pr2 = x -> x.getScore() < 50;
        Predicate<Student> studentPredicate = pr.and(pr2);
        List<Student> rsl = sc.collect(students, studentPredicate);
        List<Student> expected = new ArrayList<>();
        expected.add(new Student(10, "Surname1"));
        expected.add(new Student(30, "Surname3"));
        expected.add(new Student(40, "Surname4"));
        assertThat(rsl).isEqualTo(expected);
    }
}