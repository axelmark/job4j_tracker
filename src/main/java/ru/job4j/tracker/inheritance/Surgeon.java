package ru.job4j.tracker.inheritance;

import java.util.Date;

public class Surgeon extends Doctor {

    private String part;

    public Surgeon(String name, String surname, String education, Date birthday,
        String qualification, String part) {
        super(name, surname, education, birthday, qualification);
        this.part = part;
    }

    public String getPart() {
        return part;
    }
}
