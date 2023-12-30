package ru.job4j.tracker;

import java.util.List;

public final class SingleTracker {

    private MemTracker tracker = new MemTracker();
    private static SingleTracker singleTracker = null;

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

    public List<Item> findByName(String name) {
        return tracker.findByName(name);
    }

    public List<Item> findAll(Item item) {
        return tracker.findAll();
    }

    public boolean replace(int id, Item item) {
        return tracker.replace(id, item);
    }

    public boolean delete(int id) {
        return tracker.delete(id);
    }

}
