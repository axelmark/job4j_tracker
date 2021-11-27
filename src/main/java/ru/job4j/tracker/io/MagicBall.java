package ru.job4j.tracker.io;

import java.util.Random;
import java.util.Scanner;

public class MagicBall {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        String question = input.nextLine();
        String[] answer = {"Да", "Нет", "может быть ..."};
        System.out.print(answer[new Random().nextInt(3)]);
    }
}
