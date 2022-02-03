package ru.job4j.stream;

import java.util.stream.Stream;

enum Suit {
    Diamonds, Hearts, Spades, Clubs
}

enum Value {
    V_6, V_7, V_8
}

public class Card {

    private Suit suit;
    private Value value;

    public Card(Suit suit, Value value) {
        this.suit = suit;
        this.value = value;
    }

    public static void main(String[] args) {
        Suit[] suit = {Suit.Clubs, Suit.Diamonds, Suit.Hearts, Suit.Spades};
        Value[] values = {Value.V_6, Value.V_7, Value.V_8};

        Stream.of(suit)
            .flatMap(level -> Stream.of(values)
                .map(task -> level + " " + task))
            .forEach(System.out::println);
    }
}
