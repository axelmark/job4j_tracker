package ru.job4j.collection;

import java.util.Comparator;

public class StringCompare implements Comparator<String> {

    @Override
    public int compare(String left, String right) {
        int rsl = 0;
        int minLength = Math.min(left.length(), right.length());
        for (int i = 0; i < minLength; i++) {
            int resComp = Integer.compare(left.charAt(i), right.charAt(i));
            if (resComp != 0) {
                rsl = resComp;
                break;
            }
        }
        return rsl;
    }
}
