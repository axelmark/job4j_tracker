package ru.job4j.oop;

public class Calculator {

    private static int x = 5;

    public static int sum(int y) {
        return x + y;
    }

    public static int minus(int c) {
        return c - x;
    }

    public int divide(int d) {
        return d / x;
    }

    public int multiply(int a) {
        return x * a;
    }

    public int sumAllOperation(int e) {
        return minus(e) + sum(e) + divide(e) + multiply(e);
    }

    public static void main(String[] args) {
        int res1 = Calculator.minus(3);
        int res2 = Calculator.sum(5);
        Calculator calculator = new Calculator();
        int res3 = calculator.divide(2);
        int res4 = calculator.multiply(7);
        int result = calculator.sumAllOperation(5);
        System.out.println(result);
    }
}
