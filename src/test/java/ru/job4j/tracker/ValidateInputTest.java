package ru.job4j.tracker;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

import org.junit.Test;

public class ValidateInputTest {

    @Test
    public void whendValidInput() {
        Output out = new StubOutput();
        Input in = new StubInput(
            new String[]{"1"}
        );
        ValidateInput input = new ValidateInput(out, in);
        int selected = input.askInt("Enter menu:");
        assertThat(selected, is(1));
    }

    @Test
    public void whenMultipleValidInput() {
        Output out = new StubOutput();
        Input in = new StubInput(
            new String[]{"1", "2", "3"}
        );
        ValidateInput input = new ValidateInput(out, in);
        int selected = in.askInt("Enter menu:");
        assertThat(selected, is(1));
        selected = in.askInt("Enter menu:");
        assertThat(selected, is(2));
        selected = in.askInt("Enter menu:");
        assertThat(selected, is(3));
    }

    @Test()
    public void whenNegativeDigitInput() {
        Output out = new StubOutput();
        Input in = new StubInput(
            new String[]{"-1"}
        );
        ValidateInput input = new ValidateInput(out, in);
        int selected = in.askInt("Enter menu:");
        assertThat(selected, is(-1));
    }

}