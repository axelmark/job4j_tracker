package ru.job4j.tracker;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

public class ValidateInputTest {
   /* @Test
    public void whendValidInput() {
        Output out = new StubOutput();
        Input in = new StubInput(
                new String[]{"1"}
        );
        ValidateInput input = new ValidateInput(out, in);
        int selected = input.askInt("Enter menu:");
        assertThat(selected).isEqualTo(1);
    }

    @Test
    public void whenMultipleValidInput() {
        Output out = new StubOutput();
        Input in = new StubInput(
                new String[]{"1", "2", "3"}
        );
        ValidateInput input = new ValidateInput(out, in);
        int selected = in.askInt("Enter menu:");
        assertThat(selected).isEqualTo(1);
        selected = in.askInt("Enter menu:");
        assertThat(selected).isEqualTo(2);
        selected = in.askInt("Enter menu:");
        assertThat(selected).isEqualTo(3);
    }

    @Test()
    public void whenNegativeDigitInput() {
        Output out = new StubOutput();
        Input in = new StubInput(
                new String[]{"-1"}
        );
        ValidateInput input = new ValidateInput(out, in);
        int selected = in.askInt("Enter menu:");
        assertThat(selected).isEqualTo(-1);
    }*/
}