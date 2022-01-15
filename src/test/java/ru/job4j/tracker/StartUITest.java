package ru.job4j.tracker;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

import java.util.List;
import org.junit.Test;

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
        assertThat(tracker.findAll().get(0).getName(), is("Item name"));
    }

    @Test
    public void whenReplaceItem() {
        Output output = new StubOutput();
        Tracker tracker = new Tracker();
        List<Item> item = tracker.add(new Item("Replaced item"));
        Input in = new StubInput(
            new String[]{"0", String.valueOf(item.get(0).getId()), "New name", "1"}
        );
        UserAction[] actions = {
            new ReplaceAction(output),
            new ExitAction(output)
        };
        new StartUI(output).init(in, tracker, actions);
        String ln = System.lineSeparator();
        assertThat(output.toString(), is(
            "=== Menu: ===" + ln
                + "0. Edit item" + ln
                + "1. Exit" + ln
                + "=== Edit item ===" + ln
                + "Заявка изменена успешно." + ln
                + "=== Menu: ===" + ln
                + "0. Edit item" + ln
                + "1. Exit" + ln
                + "=== Exit Program ===" + ln

        ));
    }

    @Test
    public void whenShowAllItem() {
        Output output = new StubOutput();
        Tracker tracker = new Tracker();
        List<Item> item = tracker.add(new Item("All item"));
        Input in = new StubInput(
            new String[]{"0", "1"}
        );
        UserAction[] actions = {
            new ShowAllAction(output),
            new ExitAction(output)
        };
        new StartUI(output).init(in, tracker, actions);
        String ln = System.lineSeparator();
        assertThat(output.toString(), is(
            "=== Menu: ===" + ln
                + "0. Show all items" + ln
                + "1. Exit" + ln
                + "=== Show all items ===" + ln
                + item.toString().replaceAll("^\\[|]$", "") + ln
                + "=== Menu: ===" + ln
                + "0. Show all items" + ln
                + "1. Exit" + ln
                + "=== Exit Program ===" + ln
        ));
    }

    @Test
    public void whenFindByNameItem() {
        Output output = new StubOutput();
        Tracker tracker = new Tracker();
        List<Item> item = tracker.add(new Item("Name"));
        Input in = new StubInput(
            new String[]{"0", item.get(0).getName(), "1"}
        );
        UserAction[] actions = {
            new FindByNameAction(output),
            new ExitAction(output)
        };
        new StartUI(output).init(in, tracker, actions);
        String ln = System.lineSeparator();
        assertThat(output.toString(), is(
            "=== Menu: ===" + ln
                + "0. Find by name" + ln
                + "1. Exit" + ln
                + "=== Find items by name ===" + ln
                + item.toString().replaceAll("^\\[|]$", "") + ln
                + "=== Menu: ===" + ln
                + "0. Find by name" + ln
                + "1. Exit" + ln
                + "=== Exit Program ===" + ln
        ));
    }

    @Test
    public void whenFindByIdItem() {
        Output output = new StubOutput();
        Tracker tracker = new Tracker();
        List<Item> item = tracker.add(new Item("Find name by id"));
        Input in = new StubInput(
            new String[]{"0", String.valueOf(item.get(0).getId()), "1"}
        );
        UserAction[] actions = {
            new FindByIdAction(output),
            new ExitAction(output)
        };
        new StartUI(output).init(in, tracker, actions);
        String ln = System.lineSeparator();
        assertThat(output.toString(), is(
            "=== Menu: ===" + ln
                + "0. Find by id" + ln
                + "1. Exit" + ln
                + "=== Find item by id ===" + ln
                + item.toString().replaceAll("^\\[|]$", "") + ln
                + "=== Menu: ===" + ln
                + "0. Find by id" + ln
                + "1. Exit" + ln
                + "=== Exit Program ===" + ln
        ));
    }

    @Test
    public void whenDeleteItem() {
        Output output = new StubOutput();
        Tracker tracker = new Tracker();
        List<Item> item = tracker.add(new Item("Deleted item"));
        Input in = new StubInput(
            new String[]{"0", String.valueOf(item.get(0).getId()), "1"}
        );
        UserAction[] actions = {
            new DeleteAction(output),
            new ExitAction(output)
        };
        new StartUI(output).init(in, tracker, actions);
        String ln = System.lineSeparator();
        assertThat(output.toString(), is(
            "=== Menu: ===" + ln
                + "0. Delete item" + ln
                + "1. Exit" + ln
                + "=== Delete item ===" + ln
                + "Заявка удалена успешно." + ln
                + "=== Menu: ===" + ln
                + "0. Delete item" + ln
                + "1. Exit" + ln
                + "=== Exit Program ===" + ln
        ));
    }

}