package ru.job4j.pojo;

public class Library {

    public static void print(Book[] books) {
        for (Book book : books) {
            System.out.println(book.getName() + " - " + book.getCount());
        }
    }

    public static void print(Book[] books, String find) {
        for (Book book : books) {
            if ("Clean code".equals(book.getName())) {
                System.out.println(book.getName() + " - " + book.getCount());
            }
        }
    }

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
        Library.print(library);
        Book temp = library[0];
        library[0] = library[3];
        library[3] = temp;
        Library.print(library);
        Library.print(library, "Clean code");
    }
}
