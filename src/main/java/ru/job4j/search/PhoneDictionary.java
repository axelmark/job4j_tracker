package ru.job4j.search;

import java.util.ArrayList;
import java.util.function.Predicate;

public class PhoneDictionary {

    private final ArrayList<Person> persons = new ArrayList<>();

    public void add(Person person) {
        this.persons.add(person);
    }

    public ArrayList<Person> find(String key) {

        Predicate<Person> personPredicateName = x -> x.getName().contains(key);
        Predicate<Person> personPredicateSurname = x -> x.getSurname().contains(key);
        Predicate<Person> personPredicatePhone = x -> x.getPhone().contains(key);
        Predicate<Person> personPredicateAddress = x -> x.getAddress().contains(key);
        Predicate<Person> combine = personPredicateName.or(personPredicateSurname)
            .or(personPredicatePhone).or(personPredicateAddress);

        ArrayList<Person> result = new ArrayList<>();
        for (var person : persons) {
            if (combine.test(person)) {
                result.add(person);
            }
        }
        return result;
    }
}