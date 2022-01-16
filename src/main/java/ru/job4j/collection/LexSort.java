package ru.job4j.collection;

import java.util.Comparator;

public class LexSort implements Comparator<String> {

    @Override
    public int compare(String left, String right) {
        int rsl = 0;
        String[] lft = left.split(". ");
        String[] rgh = right.split(". ");
        int intCompRes = Integer.compare(Integer.parseInt(lft[0]), Integer.parseInt(rgh[0]));
        int strCompRes = lft[1].compareTo(rgh[1]);
        if (strCompRes == 0) {
            rsl = intCompRes;
        }
        return rsl;
    }
}