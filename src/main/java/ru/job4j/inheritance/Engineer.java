package ru.job4j.inheritance;

import java.util.Date;

public class Engineer extends Profession {

    private int specialization;

    public Engineer(String name, String surname, String education, Date birthday,
        int specialization) {
        super(name, surname, education, birthday);
        this.specialization = specialization;
    }

    public int getSpecialization() {
        return specialization;
    }
}
