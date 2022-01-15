package ru.job4j.tracker;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import org.junit.Test;

public class ItemTest {

    @Test
    public void icheckItemAscByName() {
        List<Item> items = Arrays.asList(
            new Item(1, "Petr"),
            new Item(3, "Alexey"),
            new Item(2, "Elena")
        );
        List<Item> expected = Arrays.asList(
            new Item(3, "Alexey"),
            new Item(2, "Elena"),
            new Item(1, "Petr")
        );
        Collections.sort(items, new ItemAscByName());
        assertThat(items.toString(), is(expected.toString()));
    }

    @Test
    public void checkItemDescByName() {
        List<Item> items = Arrays.asList(
            new Item(1, "Petr"),
            new Item(3, "Alexey"),
            new Item(2, "Elena")
        );
        List<Item> expected = Arrays.asList(
            new Item(1, "Petr"),
            new Item(2, "Elena"),
            new Item(3, "Alexey")
        );
        Collections.sort(items, new ItemDescByName());
        assertThat(items.toString(), is(expected.toString()));
    }
}