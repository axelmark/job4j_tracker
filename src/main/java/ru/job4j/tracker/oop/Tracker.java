package ru.job4j.tracker.oop;

import java.util.ArrayList;
import java.util.List;

public class Tracker {

    private final List<Item> items = new ArrayList<>();
    private int ids = 1;

    public List<Item> add(Item item) {
        item.setId(ids++);
        items.add(item);
        return items;
    }

    public List<Item> findByName(String name) {
        List<Item> res = new ArrayList<>();
        for (var item : items) {
            if (item.getName().contains(name)) {
                res.add(item);
            }
        }
        return res;
    }

    public Item findById(int id) {
        int index = indexOf(id);
        if (index != -1) {
            return items.get(index);
        }
        return null;
    }

    public List<Item> findAll() {
        return items;
    }

    private int indexOf(int id) {
        int index = -1;
        for (int ind = 0; ind < items.size(); ind++) {
            if (items.get(ind).getId() == id) {
                index = ind;
                break;
            }
        }
        return index;
    }

    public boolean replace(int id, Item item) {
        int index = indexOf(id);
        if (index != -1) {
            item.setId(id);
            items.set(index, item);
            return true;
        }
        return false;
    }

    public boolean delete(int id) {
        int index = indexOf(id);
        if (index != -1) {
            items.remove(index);
            return true;
        }
        return false;
    }

}