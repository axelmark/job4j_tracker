package ru.job4j.tracker.oop;

import ru.job4j.tracker.ConsoleInput;
import ru.job4j.tracker.CreateAction;
import ru.job4j.tracker.DeleteAction;
import ru.job4j.tracker.Exit;
import ru.job4j.tracker.FindByIdAction;
import ru.job4j.tracker.FindByNameAction;
import ru.job4j.tracker.Input;
import ru.job4j.tracker.ReplaceAction;
import ru.job4j.tracker.ShowAllAction;
import ru.job4j.tracker.UserAction;

public class StartUI {

    public void init(Input input, Tracker tracker, UserAction[] actions) {
        boolean run = true;
        while (run) {
            System.out.println("=== Menu: ===");
            this.showMenu();
            int select = Integer.parseInt(input.askStr("Enter id: "));
            if (select == 0) {
                run = actions[select].execute(input, tracker);
            } else if (select == 1) {
                run = actions[select].execute(input, tracker);
            } else if (select == 2) {
                run = actions[select].execute(input, tracker);
            } else if (select == 3) {
                run = actions[select].execute(input, tracker);
            } else if (select == 4) {
                run = actions[select].execute(input, tracker);
            } else if (select == 5) {
                run = actions[select].execute(input, tracker);
            } else if (select == 6) {
                run = actions[select].execute(input, tracker);
            }
        }
    }

    private void showMenu() {
        String[] menu = {
            "Add new Item", "Show all items", "Edit item",
            "Delete item", "Find item by id", "Find items by name",
            "Exit Program"
        };
        for (int i = 0; i < menu.length; i++) {
            System.out.println(i + ". " + menu[i]);
        }
    }

    public static void main(String[] args) {
        Input input = new ConsoleInput();
        Tracker tracker = new Tracker();
        UserAction[] actions = {
            new CreateAction(),
            new ShowAllAction(),
            new ReplaceAction(),
            new DeleteAction(),
            new FindByIdAction(),
            new FindByNameAction(),
            new Exit()
        };
        new StartUI().init(input, tracker, actions);
    }
}
