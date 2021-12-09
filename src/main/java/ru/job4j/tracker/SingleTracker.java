package ru.job4j.tracker;

import ru.job4j.tracker.oop.Item;
import ru.job4j.tracker.oop.Tracker;

public final class SingleTracker {

    private Tracker tracker = new Tracker();
    SingleTracker singleTracker = null;

    private SingleTracker() {
    }

    public SingleTracker getSingleTracker() {
        if (singleTracker == null) {
            singleTracker = new SingleTracker();
        }
        return singleTracker;
    }

    public Item add(Item item) {
        return tracker.add(item);
    }

    public Item findById(int id) {
        return tracker.findById(id);
    }

    public Item[] findByName(String name) {
        return tracker.findByName(name);
    }

    public Item[] findAll(Item item) {
        return tracker.findAll();
    }

    public boolean replace(int id, Item item) {
        return tracker.replace(id, item);
    }

    public boolean delete(int id) {
        return tracker.delete(id);
    }
}