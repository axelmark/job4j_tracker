package ru.job4j.tracker.oop;

import java.util.Arrays;

public class Tracker {

    private final Item[] items = new Item[100];
    private int ids = 1;
    private int size = 0;

    public Item add(Item item) {
        item.setId(ids++);
        items[size++] = item;
        return item;
    }

    public Item[] findByName(String name) {
        Item[] current = findAll();
        Item[] res = new Item[size];
        int size = 0;
        for (int i = 0; i < current.length; i++) {
            if (name.equals(current[i].getName())) {
                res[i] = current[i];
                size++;
            }
        }
        return Arrays.copyOf(res, size);
    }

    public Item[] findAll() {
        return Arrays.copyOf(items, size);
    }

    public Item findById(int id) {
        Item rsl = null;
        for (int index = 0; index < size; index++) {
            Item item = items[index];
            if (item.getId() == id) {
                rsl = item;
                break;
            }
        }
        return rsl;
    }
}