package ru.job4j.map;

import java.util.Map;
import java.util.Optional;
import java.util.Set;

public class College {

    private final Map<Student, Set<Subject>> students;

    public College(Map<Student, Set<Subject>> students) {
        this.students = students;
    }

    public Optional<Student> findByAccount(String account) {
        Optional<Student> rsl = Optional.empty();
        for (Student student : students.keySet()) {
            if (student.getAccount().equals(account)) {
                rsl = Optional.of(student);
                break;
            }
        }
        return rsl;
    }

    public Optional<Subject> findBySubjectName(String account, String name) {
        Optional<Subject> rsl = Optional.empty();
        Optional<Student> st = findByAccount(account);
        if (st.isPresent()) {
            for (Subject val : students.get(st.get())) {
                if (val.getName().equals(name)) {
                    rsl = Optional.of(val);
                    break;
                }
            }
        }
        return rsl;
    }

    public static void main(String[] args) {
        Map<Student, Set<Subject>> students = Map.of(
            new Student("Student1", "000001", "201-18-15"),
            Set.of(
                new Subject("Math", 70),
                new Subject("English", 85)
            ),
            new Student("Student2", "000002", "201-18-15"),
            Set.of(
                new Subject("Economic", 75),
                new Subject("Sociology", 65)
            )
        );
        College college = new College(students);
        Optional<Student> student = college.findByAccount("000001");
        System.out.println("Найденный студент: " + student);

        Optional<Subject> english = college.findBySubjectName("000001", "English");
        System.out.println("Оценка по найденному предмету: " + english);
    }
}