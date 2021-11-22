package ru.job4j.tracker.inheritance;

import java.util.Date;

public class Builder extends Engineer {

    private String calculate;

    public Builder(String name, String surname, String education, Date birthday,
        int specialization, String calculate) {
        super(name, surname, education, birthday, specialization);
        this.calculate = calculate;
    }

    public String getCalculate() {
        return calculate;
    }
}
