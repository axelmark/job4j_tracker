package ru.job4j.tracker.oop;


import ru.job4j.tracker.ConsoleInput;
import ru.job4j.tracker.CreateAction;
import ru.job4j.tracker.DeleteAction;
import ru.job4j.tracker.FindByIdAction;
import ru.job4j.tracker.FindByNameAction;
import ru.job4j.tracker.Input;
import ru.job4j.tracker.ReplaceAction;
import ru.job4j.tracker.ShowAllAction;
import ru.job4j.tracker.UserAction;

public class StartUI {

    UserAction[] actions = {
        new CreateAction(),
        new ShowAllAction(),
        new ReplaceAction(),
        new DeleteAction(),
        new FindByIdAction(),
        new FindByNameAction(),
    };

    public void init(Input input, Tracker tracker) {
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
                run = false;
            }
        }
    }

    private void showMenu() {
        for (int i = 0; i < actions.length; i++) {
            System.out.println(i + " ." + actions[i].name());
        }
    }

    public static void main(String[] args) {
        Input input = new ConsoleInput();
        Tracker tracker = new Tracker();
        new StartUI().init(input, tracker);
    }
}
