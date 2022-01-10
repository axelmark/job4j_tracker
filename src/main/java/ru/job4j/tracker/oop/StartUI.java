package ru.job4j.tracker.oop;

//import ru.job4j.tracker.ConsoleInput;
//import ru.job4j.tracker.ConsoleOutput;
//import ru.job4j.tracker.CreateAction;
//import ru.job4j.tracker.DeleteAction;
//import ru.job4j.tracker.ExitAction;
//import ru.job4j.tracker.FindByIdAction;
//import ru.job4j.tracker.FindByNameAction;
//import ru.job4j.tracker.Input;
//import ru.job4j.tracker.Log4File;
//import ru.job4j.tracker.Output;
//import ru.job4j.tracker.ReplaceAction;
//import ru.job4j.tracker.ShowAllAction;
//import ru.job4j.tracker.UserAction;
//import ru.job4j.tracker.ValidateInput;

import ru.job4j.tracker.ConsoleInput;
import ru.job4j.tracker.ConsoleOutput;
import ru.job4j.tracker.CreateAction;
import ru.job4j.tracker.DeleteAction;
import ru.job4j.tracker.ExitAction;
import ru.job4j.tracker.FindByIdAction;
import ru.job4j.tracker.FindByNameAction;
import ru.job4j.tracker.Input;
import ru.job4j.tracker.Log4File;
import ru.job4j.tracker.Output;
import ru.job4j.tracker.ReplaceAction;
import ru.job4j.tracker.ShowAllAction;
import ru.job4j.tracker.UserAction;
import ru.job4j.tracker.ValidateInput;

public class StartUI {

    private final Output out;

    public StartUI(Output out) {
        this.out = out;
    }

    public void init(Input input, Tracker tracker, UserAction[] actions) {
        boolean run = true;
        while (run) {
            this.showMenu(actions);
            int select = input.askInt("Select: ");

            if (select < 0 || select >= actions.length) {
                out.println("Wrong input, you can select: 0 .. " + (actions.length - 1));
                throw new NumberFormatException();
            }
            UserAction action = actions[select];
            run = action.execute(input, tracker);
        }
    }

    private void showMenu(UserAction[] actions) {
        out.println("=== Menu: ===");
        for (int i = 0; i < actions.length; i++) {
            out.println(i + ". " + actions[i].name());
        }
    }

    public static void main(String[] args) {
        Output output = new ConsoleOutput();
        Input input = new ValidateInput(output, new ConsoleInput());
        Tracker tracker = new Tracker();
        UserAction[] actions = {
            new CreateAction(output),
            new ShowAllAction(output),
            new ReplaceAction(output),
            new DeleteAction(output),
            new FindByIdAction(output),
            new FindByNameAction(output),
            new ExitAction(output),
        };
        new StartUI(output).init(input, tracker, actions);
        Log4File log = Log4File.getInstance();
        log.add("add new Item");
        log.save();
    }
}