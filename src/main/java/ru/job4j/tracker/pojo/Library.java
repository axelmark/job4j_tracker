package ru.job4j.tracker.pojo;

public class Library {

    public static void main(String[] args) {
        Book java = new Book("Java", 8);
        Book arrays = new Book("Arrays", 10);
        Book methods = new Book("Method", 15);
        Book cleanBook = new Book("Clean code", 20);
        Book[] library = new Book[4];
        library[0] = java;
        library[1] = arrays;
        library[2] = methods;
        library[3] = cleanBook;
        Book.print(library);
        Book temp = library[0];
        library[0] = library[3];
        library[3] = temp;
        Book.print(library);
        Book.print(library, "Clean code");
    }
}
