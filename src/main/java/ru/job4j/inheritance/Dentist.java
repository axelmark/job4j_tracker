package ru.job4j.inheritance;

import java.util.Date;

public class Dentist extends Doctor {

    private String tooth;

    public Dentist(String name, String surname, String education, Date birthday,
        String qualification, String tooth) {
        super(name, surname, education, birthday, qualification);
        this.tooth = tooth;
    }

    public String getTooth() {
        return tooth;
    }
}
