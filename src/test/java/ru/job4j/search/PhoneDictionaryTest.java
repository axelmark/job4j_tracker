package ru.job4j.search;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

import org.junit.Test;

public class PhoneDictionaryTest {

    @Test
    public void whenFindByName() {
        var phones = new PhoneDictionary();
        phones.add(
            new Person("Petr", "Arsentev", "534872", "Bryansk")
        );
        var persons = phones.find("Petr");
        assertThat(persons.get(0).getSurname(), is("Arsentev"));
    }

    @Test
    public void whenNotFind() {
        var phones = new PhoneDictionary();
        phones.add(
            new Person("Petr", "Arsentev", "534872", "Bryansk")
        );
        var persons = phones.find("FInd");
        assertThat(persons.isEmpty(), is(true));
    }
}

