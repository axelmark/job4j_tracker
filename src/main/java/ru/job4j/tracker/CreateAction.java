package ru.job4j.tracker;

import ru.job4j.tracker.oop.Item;
import ru.job4j.tracker.oop.Tracker;

public class CreateAction implements UserAction {

    @Override
    public String name() {
        return "Add new Item";
    }

    @Override
    public boolean execute(Input input, Tracker tracker) {
        System.out.println("=== Create a new Item ===");
        String name = input.askStr("Enter name: ");
        Item item = new Item(name);
        tracker.add(item);
        System.out.println("Добавленная заявка: " + item);
        return true;
    }
}