package ru.job4j.tracker.oop;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.nullValue;

import org.junit.Test;
import ru.job4j.tracker.CreateAction;
import ru.job4j.tracker.DeleteAction;
import ru.job4j.tracker.Exit;
import ru.job4j.tracker.Input;
import ru.job4j.tracker.Output;
import ru.job4j.tracker.ReplaceAction;
import ru.job4j.tracker.StubInput;
import ru.job4j.tracker.StubOutput;
import ru.job4j.tracker.UserAction;

public class StartUITest {

    @Test
    public void whenCreateItem() {
        Output output = new StubOutput();
        Input in = new StubInput(
            new String[]{"0", "Item name", "1"}
        );
        Tracker tracker = new Tracker();
        UserAction[] actions = {
            new CreateAction(output),
            new Exit()
        };
        new StartUI(output).init(in, tracker, actions);
        assertThat(tracker.findAll()[0].getName(), is("Item name"));
    }

    @Test
    public void whenReplaceItem() {
        Output output = new StubOutput();
        Tracker tracker = new Tracker();
        Item item = tracker.add(new Item("Replaced item"));
        String replacedName = "New item name";
        Input in = new StubInput(
            new String[]{"0", "1", replacedName, "1"}
        );
        UserAction[] actions = {
            new ReplaceAction(output),
            new Exit()
        };
        new StartUI(output).init(in, tracker, actions);
        assertThat(tracker.findById(item.getId()).getName(), is(replacedName));
    }

    @Test
    public void whenDeleteItem() {
        Output output = new StubOutput();
        Tracker tracker = new Tracker();
        Item item = tracker.add(new Item("Deleted item"));
        Input in = new StubInput(
            new String[]{"0", String.valueOf(item.getId()), "1"}
        );
        UserAction[] actions = {
            new DeleteAction(output),
            new Exit()
        };
        new StartUI(output).init(in, tracker, actions);
        assertThat(tracker.findById(item.getId()), is(nullValue()));
    }

//    @Test
//    public void whenExit() {
//        Output output = new StubOutput();
//        Input in = new StubInput(
//            new String[]{"0"}
//        );
//        Tracker tracker = new Tracker();
//        UserAction[] actions = {
//            new Exit()
//        };
//        new StartUI(output).init(in, tracker, actions);
//        assertThat(output.toString(), is("Menu."
//            + System.lineSeparator()
//            + "0. Exit" + System.lineSeparator()
//        ));
//    }
}