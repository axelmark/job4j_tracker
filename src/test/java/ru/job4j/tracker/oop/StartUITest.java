package ru.job4j.tracker.oop;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.nullValue;

import org.junit.Test;
import ru.job4j.tracker.CreateAction;
import ru.job4j.tracker.DeleteAction;
import ru.job4j.tracker.ExitAction;
import ru.job4j.tracker.FindByNameAction;
import ru.job4j.tracker.Input;
import ru.job4j.tracker.Output;
import ru.job4j.tracker.ReplaceAction;
import ru.job4j.tracker.ShowAllAction;
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
            new ExitAction(output)
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
            new ExitAction(output)
        };
        new StartUI(output).init(in, tracker, actions);
        assertThat(tracker.findById(item.getId()).getName(), is(replacedName));
    }

    @Test
    public void whenShowAllItem() {
        Output output = new StubOutput();
        Tracker tracker = new Tracker();
        Item item = tracker.add(new Item("All item"));
        Input in = new StubInput(
            new String[]{"0", "1"}
        );
        UserAction[] actions = {
            new ShowAllAction(output),
            new ExitAction(output)
        };
        new StartUI(output).init(in, tracker, actions);
        assertThat(tracker.findAll()[0].getName(), is("All item"));
    }

    @Test
    public void whenFindByNameItem() {
        Output output = new StubOutput();
        Tracker tracker = new Tracker();
        Item item = tracker.add(new Item("Find name"));
        Input in = new StubInput(
            new String[]{"0", item.getName(), "1"}
        );
        UserAction[] actions = {
            new FindByNameAction(output),
            new ExitAction(output)
        };
        new StartUI(output).init(in, tracker, actions);
        assertThat(tracker.findAll()[0].getName(), is(item.getName()));
    }

    @Test
    public void whenFindByIdItem() {
        Output output = new StubOutput();
        Tracker tracker = new Tracker();
        Item item = tracker.add(new Item("Find name by id"));
        Input in = new StubInput(
            new String[]{"0", String.valueOf(item.getId()), "1"}
        );
        UserAction[] actions = {
            new FindByNameAction(output),
            new ExitAction(output)
        };
        new StartUI(output).init(in, tracker, actions);
        assertThat(tracker.findById(item.getId()).getName(), is(item.getName()));
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
            new ExitAction(output)
        };
        new StartUI(output).init(in, tracker, actions);
        assertThat(tracker.findById(item.getId()), is(nullValue()));
    }
}