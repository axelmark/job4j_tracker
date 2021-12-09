package ru.job4j.tracker;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

import org.junit.Test;

public class ValidateInputTest {

    @Test
    public void whenInvalidInput() {
        Output out = new StubOutput();
        Input in = new StubInput(
            new String[]{"1", "2", "3"}
        );
        ValidateInput input = new ValidateInput(out, in);
        int selected = in.askInt("Enter menu:");
        assertThat(selected, is(1));
    }

    @Test(expected = NumberFormatException.class)
    public void whenNotDigitInput() {
        Output out = new StubOutput();
        Input in = new StubInput(
            new String[]{"q", "sdfs", "q3eew"}
        );
        ValidateInput input = new ValidateInput(out, in);
        int selected = in.askInt("Enter menu:");
    }
}