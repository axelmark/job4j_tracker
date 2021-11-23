package ru.job4j.tracker.inheritance;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class JSONReportTest {

    @Test
    public void whenTestGenerateMethod() {
        String ln = System.lineSeparator();
        String expected = "{" + ln
            + "\t\"name\" : \"Report's name\"," + ln
            + "\t\"body\" : \"Report's body\"" + ln
            + "}";
        String name = "Report's name";
        String body = "Report's body";
        String result = new JSONReport().generate(name, body);
        assertEquals(expected, result);
    }
}