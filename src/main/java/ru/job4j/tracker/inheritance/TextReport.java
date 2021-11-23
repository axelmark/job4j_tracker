package ru.job4j.tracker.inheritance;

public class TextReport {

    public String generate(String name, String body) {
        return name + System.lineSeparator() + body;

    }

    public static void main(String[] args) {
        JSONReport textReport = new JSONReport();
        String str = textReport.generate("Zhak", "asd");
        System.out.println(str);
    }
}
