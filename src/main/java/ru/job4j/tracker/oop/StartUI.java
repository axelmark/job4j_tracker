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
            this.showMenu(actions);
            int select = input.askInt("Select: ");
            UserAction action = actions[select];
            run = action.execute(input, tracker);
        }
    }

    private void showMenu(UserAction[] actions) {
        for (int i = 0; i < actions.length; i++) {
            System.out.println(i + ". " + actions[i].name());
        }
    }

//    public static void main(String[] args) {
//        Input input = new ConsoleInput();
//        Tracker tracker = new Tracker();
//        UserAction[] actions = {
//            new CreateAction(),
//            new ShowAllAction(),
//            new ReplaceAction(),
//            new DeleteAction(),
//            new FindByIdAction(),
//            new FindByNameAction(),
//            new Exit()
//        };
//        new StartUI().init(input, tracker, actions);
//    }
}