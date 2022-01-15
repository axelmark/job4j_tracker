package ru.job4j.tracker.auto;

import java.util.Comparator;

public class SortByName implements Comparator<Auto> {

    @Override
    public int compare(Auto o1, Auto o2) {
        return o1.getMarka().compareTo(o2.getMarka());
    }
}
