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
        for (Book value : library) {
            System.out.println(value.getName() + " - " + value.getCount());
        }
        Book temp = library[0];
        library[0] = library[3];
        library[3] = temp;
        for (Book book : library) {
            System.out.println(book.getName() + " - " + book.getCount());

        }
        for (int i = 0; i < library.length; i++) {
            if (library[i].getName().equals("Clean code")) {
                System.out.println(library[i].getName() + " - " + library[i].getCount());
            }
        }
    }
}
