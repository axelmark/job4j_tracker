package ru.job4j.tracker.inheritance;

import java.util.Date;

public class Doctor extends Profession {

    private String qualification;

    public Doctor(String name, String surname, String education, Date birthday,
        String qualification) {
        super(name, surname, education, birthday);
        this.qualification = qualification;
    }

    public String getQualification() {
        return qualification;
    }
}
