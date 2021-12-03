package ru.job4j.tracker;

import ru.job4j.tracker.oop.Tracker;

public class Exit implements UserAction {

    @Override
    public String name() {
        return "Exit";
    }

    @Override
    public boolean execute(Input input, Tracker tracker) {
        return false;
    }
}
