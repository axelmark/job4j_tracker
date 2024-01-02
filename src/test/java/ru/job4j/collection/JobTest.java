package ru.job4j.collection;

import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.*;

import java.util.Comparator;

public class JobTest {

    @Test
    public void whenComporatorByPriorityAsc() {
        int rsl = new JobAscByPriority().compare(
            new Job("Impl task", 0),
            new Job("Fix bug", 1)
        );
        assertThat(rsl).isLessThan(0);
    }

    @Test
    public void whenComporatorByPriorityDesc() {
        int rsl = new JobDescByPriority().compare(
            new Job("Impl task", 0),
            new Job("Fix bug", 1)
        );
        assertThat(rsl).isGreaterThan(0);
    }

    @Test
    public void whenComporatorByNameAsc() {
        int rsl = new JobAscByName().compare(
            new Job("Impl task", 0),
            new Job("Fix bug", 1)
        );
        assertThat(rsl).isGreaterThan(0);
    }

    @Test
    public void whenComporatorByNameDesc() {
        int rsl = new JobDescByPriority().compare(
            new Job("Impl task", 0),
            new Job("Fix bug", 1)
        );
        assertThat(rsl).isGreaterThan(0);
    }

    @Test
    public void whenCompatorByNameAndProrityAsc() {
        Comparator<Job> cmpNamePriority = new JobAscByName()
            .thenComparing(new JobAscByPriority());
        int rsl = cmpNamePriority.compare(
            new Job("Fix bug", 0),
            new Job("Fix bug", 1)
        );
        assertThat(rsl).isLessThan(0);
    }

    @Test
    public void whenCompatorByNameAndProrityDesc() {
        Comparator<Job> cmpNamePriority = new JobDescByName()
            .thenComparing(new JobDescByPriority());
        int rsl = cmpNamePriority.compare(
            new Job("Fix bug", 0),
            new Job("Fix bug", 1)
        );
        assertThat(rsl).isGreaterThan(0);
    }
}