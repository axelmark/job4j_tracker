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
        Item[] res = new Item[size];
        int count = 0;
        for (int i = 0; i < size; i++) {
            if (name.equals(items[i].getName())) {
                res[count] = items[i];
                count++;
            }
        }
        return Arrays.copyOf(res, count);
    }

    public Item findById(int id) {
        for (Item item : items) {
            if (item != null && id == item.getId()) {
                return item;
            }
        }
        return null;
    }

    public Item[] findAll() {
        return Arrays.copyOf(items, size);
    }

    private int indexOf(int id) {
        int rsl = -1;

        for (int index = 0; index < items.length; index++) {
            if (items[index] != null && id == items[index].getId()) {
                rsl = index;
                break;
            }
        }
        return rsl;
    }

    public boolean replace(int id, Item item) {
        int index = indexOf(id);
        if (index != -1) {
            item.setId(id);
            items[index] = item;
            return true;
        }
        return false;
    }

    public boolean delete(int id) {
        int index = indexOf(id);
        if (index != -1) {
            System.arraycopy(items, index + 1, items, index, size - index - 1);
            items[size - 1] = null;
            size--;
            return true;
        }
        return false;
    }
}