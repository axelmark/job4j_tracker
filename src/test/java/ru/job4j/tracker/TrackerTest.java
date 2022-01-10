package ru.job4j.tracker;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

import java.util.List;
import org.junit.Test;
import ru.job4j.tracker.oop.Item;

public class TrackerTest {

    @Test
    public void whenTestFindById() {
        Tracker tracker = new Tracker();
        Item bug = new Item("Bug");
        List<Item> item = tracker.add(bug);
        Item result = tracker.findById(item.get(0).getId());
        assertThat(result.getName(), is(item.get(0).getName()));
    }

    @Test
    public void whenTestFindAll() {
        Tracker tracker = new Tracker();
        Item first = new Item("First");
        Item second = new Item("Second");
        tracker.add(first);
        tracker.add(second);
        List<Item> result = tracker.findAll();

        assertThat(result.get(0).getName(), is(first.getName()));
        assertThat(result.get(1).getName(), is(second.getName()));
    }

    @Test
    public void whenTestFindByNameCheckArrayLength() {
        Tracker tracker = new Tracker();
        Item first = new Item("First");
        Item second = new Item("Second");
        tracker.add(first);
        tracker.add(second);
        tracker.add(new Item("First"));
        tracker.add(new Item("Second"));
        tracker.add(new Item("First"));
        List<Item> result = tracker.findByName(first.getName());
        assertThat(result.size(), is(3));
    }

    @Test
    public void whenTestFindByNameCheckSecondItemName() {
        Tracker tracker = new Tracker();
        Item first = new Item("First");
        Item second = new Item("Second");
        tracker.add(first);
        tracker.add(second);
        tracker.add(new Item("First"));
        tracker.add(new Item("Second"));
        tracker.add(new Item("First"));
        List<Item> result = tracker.findByName(second.getName());
        assertThat(result.get(1).getName(), is(second.getName()));
    }

    @Test
    public void whenReplace() {
        Tracker tracker = new Tracker();
        Item bug = new Item();
        bug.setName("Bug");
        tracker.add(bug);
        int id = bug.getId();
        Item bugWithDesc = new Item();
        bugWithDesc.setName("Bug with description");
        boolean rsl = tracker.replace(id, bugWithDesc);
        assertThat(rsl, is(true));
    }

    @Test
    public void whenDelete() {
        Tracker tracker = new Tracker();
        Item bug = new Item();
        bug.setName("Bug");
        tracker.add(bug);
        int id = bug.getId();
        boolean rsl = tracker.delete(id);
        assertThat(rsl, is(true));
    }

    @Test
    public void whenDelete1() {
        Tracker tracker = new Tracker();
        Item first = new Item();
        Item second = new Item();
        first.setName("Bug");
        second.setName("Bug2");
        tracker.add(first);
        tracker.add(second);
        int id = second.getId();
        boolean rsl = tracker.delete(id);
        assertThat(rsl, is(true));
    }

}