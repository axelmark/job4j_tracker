package ru.job4j.collection;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.greaterThan;
import static org.hamcrest.Matchers.lessThan;

import java.util.Comparator;
import org.junit.Test;

public class JobTest {

    @Test
    public void whenComporatorByPriorityAsc() {
        int rsl = new JobAscByPriority().compare(
            new Job("Impl task", 0),
            new Job("Fix bug", 1)
        );
        assertThat(rsl, lessThan(0));
    }

    @Test
    public void whenComporatorByPriorityDesc() {
        int rsl = new JobDescByPriority().compare(
            new Job("Impl task", 0),
            new Job("Fix bug", 1)
        );
        assertThat(rsl, greaterThan(0));
    }

    @Test
    public void whenComporatorByNameAsc() {
        int rsl = new JobAscByName().compare(
            new Job("Impl task", 0),
            new Job("Fix bug", 1)
        );
        assertThat(rsl, greaterThan(0));
    }

    @Test
    public void whenComporatorByNameDesc() {
        int rsl = new JobDescByPriority().compare(
            new Job("Impl task", 0),
            new Job("Fix bug", 1)
        );
        assertThat(rsl, greaterThan(0));
    }

    @Test
    public void whenCompatorByNameAndProrityAsc() {
        Comparator<Job> cmpNamePriority = new JobAscByName()
            .thenComparing(new JobAscByPriority());
        int rsl = cmpNamePriority.compare(
            new Job("Fix bug", 0),
            new Job("Fix bug", 1)
        );
        assertThat(rsl, lessThan(0));
    }

    @Test
    public void whenCompatorByNameAndProrityDesc() {
        Comparator<Job> cmpNamePriority = new JobDescByName()
            .thenComparing(new JobDescByPriority());
        int rsl = cmpNamePriority.compare(
            new Job("Fix bug", 0),
            new Job("Fix bug", 1)
        );
        assertThat(rsl, greaterThan(0));
    }
}