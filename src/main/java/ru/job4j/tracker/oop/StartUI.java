package ru.job4j.tracker.oop;

import ru.job4j.tracker.ConsoleInput;
import ru.job4j.tracker.ConsoleOutput;
import ru.job4j.tracker.CreateAction;
import ru.job4j.tracker.DeleteAction;
import ru.job4j.tracker.Exit;
import ru.job4j.tracker.FindByIdAction;
import ru.job4j.tracker.FindByNameAction;
import ru.job4j.tracker.Input;
import ru.job4j.tracker.Output;
import ru.job4j.tracker.ReplaceAction;
import ru.job4j.tracker.ShowAllAction;
import ru.job4j.tracker.UserAction;

public class StartUI {

    private final Output out;

    public StartUI(Output out) {
        this.out = out;
    }

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

    public static void main(String[] args) {
        Output output = new ConsoleOutput();
        Input input = new ConsoleInput();
        Tracker tracker = new Tracker();
        UserAction[] actions = {
            new CreateAction(output),
            new ShowAllAction(output),
            new ReplaceAction(output),
            new DeleteAction(output),
            new FindByIdAction(output),
            new FindByNameAction(output),
            new Exit()
        };
        new StartUI(output).init(input, tracker, actions);
    }
}