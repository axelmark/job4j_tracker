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
        for (Item item : items) {
            if (item.getId() == id) {
                return item;
            }
        }
        return null;
    }

    private int indexOf(int id) {
        int rsl = -1;
        for (Item item : items) {
            if (id == item.getId()) {
                rsl = id;
                break;
            }
        }
        return rsl;
    }

    public boolean replace(int id, Item item) {
        int index = indexOf(id);
        if (index != -1) {
            items[index] = item;
            System.out.println(items[index]);
            return true;
        }
        return false;
    }

    public boolean delete(int id) {
        int index = indexOf(id);
        if (index != -1) {
            System.arraycopy(items, index + 1, items, index, items.length - size - 1);
            size--;
            items[items.length - 1] = null;
            return true;
        }
        return false;
    }
}