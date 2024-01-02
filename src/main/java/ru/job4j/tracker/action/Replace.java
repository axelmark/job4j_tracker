package ru.job4j.tracker.action;

import ru.job4j.tracker.*;

import java.sql.Timestamp;

public class Replace implements UserAction {

    private final Output out;

    public Replace(Output out) {
        this.out = out;
    }

    @Override
    public String name() {
        return "Edit item";
    }

    @Override
    public boolean execute(Input input, Store tracker) {
        out.println("=== Edit item ===");
        int id = input.askInt("Enter id: ");
        String name = input.askStr("Enter name: ");
        if (tracker.replace(id, new Item(id, name, Timestamp.valueOf(tracker.findById(id).getCreated())))) {
            out.println("Заявка изменена успешно.");
        } else {
            out.println("Ошибка замены заявки.");
        }
        return true;
    }
}
