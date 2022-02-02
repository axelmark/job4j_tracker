package ru.job4j.stream;

import java.util.stream.Stream;

public class Card {

    public enum Suit {
        Diamonds, Hearts, Spades, Clubs
    }

    public enum Value {
        V_6, V_7, V_8
    }

    public Card(Suit[] suit, Value[] value) {
        Stream.of(suit)
            .flatMap(level -> Stream.of(value)
                .map(task -> level + " " + task))
            .forEach(System.out::println);
    }

    public static void main(String[] args) {
        Suit[] suits = {Suit.Diamonds, Suit.Clubs, Suit.Hearts, Suit.Spades};
        Value[] values = {Value.V_6, Value.V_7, Value.V_8};
        Card card = new Card(suits, values);
    }
}