package ru.job4j.tracker.pojo;

import java.util.Date;

public class College {

    public static void main(String[] args) {
        Student student = new Student();
        student.setFirstname("Kate");
        student.setLastname("Middleton");
        student.setGroup(223);
        student.setReceipt(new Date("2008/8/1"));
        System.out
            .print((
                "Firstname: " + student.getFirstname() + System.lineSeparator()
                    + "Lastname: " + student.getLastname() + System.lineSeparator()
                    + "Group: " + student.getGroup() + System.lineSeparator()
                    + "Receipt date: " + student.getReceipt()
            ));
    }
}
