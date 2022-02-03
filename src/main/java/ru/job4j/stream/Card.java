package ru.job4j.stream;

import java.util.stream.Stream;

public class Card {

    private Suit[] suit;
    private Value[] value;

    public Suit[] getSuit() {
        return suit;
    }

    public Value[] getValue() {
        return value;
    }

    public enum Suit {
        Diamonds, Hearts, Spades, Clubs
    }

    public enum Value {
        V_6, V_7, V_8
    }

    public Card(Suit[] suit, Value[] value) {
        this.suit = suit;
        this.value = value;
    }

    public static void main(String[] args) {
        Card card = new Card(
            new Suit[]{Suit.Diamonds, Suit.Clubs, Suit.Hearts, Suit.Spades},
            new Value[]{Value.V_6, Value.V_7, Value.V_8}
        );

        Stream.of(card.getSuit())
            .flatMap(level -> Stream.of(card.getValue())
                .map(task -> level + " " + task))
            .forEach(System.out::println);
    }
}