package ru.job4j.tracker.action;

import ru.job4j.tracker.Input;
import ru.job4j.tracker.Output;
import ru.job4j.tracker.MemTracker;

public class Exit implements UserAction {

    private final Output out;

    public Exit(Output out) {
        this.out = out;
    }

    @Override
    public String name() {
        return "Exit";
    }

    @Override
    public boolean execute(Input input, MemTracker tracker) {
        out.println("=== Exit Program ===");
        return false;
    }
}
