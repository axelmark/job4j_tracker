package ru.job4j.lambda;


import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

import java.util.Arrays;
import java.util.List;
import org.junit.Test;
import ru.job4j.function.FunctionCalculator;

public class FunctionCalculatorTest {

    @Test
    public void whenLinearFunctionThenLinearResults() {
        FunctionCalculator functionCalculator = new FunctionCalculator();
        List<Double> result = functionCalculator.diapason(5, 8, x -> 2 * x + 1);
        List<Double> expected = Arrays.asList(11D, 13D, 15D);
        assertThat(result, is(expected));
    }

    @Test
    public void whenQuadraticFunctionThenQuadraticResults() {
        FunctionCalculator functionCalculator = new FunctionCalculator();
        List<Double> result = functionCalculator.diapason(5, 8, x -> Math.pow(x, 2));
        List<Double> expected = Arrays.asList(25D, 36D, 49D);
        assertThat(result, is(expected));
    }

    @Test
    public void whenExponentialFunctionThenExponentialResults() {
        FunctionCalculator functionCalculator = new FunctionCalculator();
        List<Double> result = functionCalculator.diapason(5, 8, x -> Math.pow(2, x));
        List<Double> expected = Arrays.asList(32D, 64D, 128D);
        assertThat(result, is(expected));
    }
}