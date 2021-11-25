package ru.job4j.tracker.pojo;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

import org.junit.Test;

public class LicenseTest {

    @Test
    public void eqName() {
        License first = new License();
        first.setCode("audio");
        License second = new License();
        second.setCode("audio");
        assertThat(first, is(second));
    }
}