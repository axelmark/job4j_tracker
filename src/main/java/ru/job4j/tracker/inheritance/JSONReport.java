package ru.job4j.tracker.inheritance;

public class JSONReport extends TextReport {

    public String generate(String name, String body) {
        return "{\n"
            + "\t\"name\" : " + "\"" + name + "\","
            + System.lineSeparator()
            + "\t\"body\" : " + "\"" + body + "\""
            + "\n}";
    }
}