package ru.job4j.tracker.oop;

public class Error {

    private boolean active;
    private int status;
    private String message;

    public Error() {
    }

    public Error(boolean active, int status, String message) {
        this.active = active;
        this.status = status;
        this.message = message;
    }

    public void show() {
        System.out.println(this.active + "\n" + this.status + "\n" + this.message);
    }

    public static void main(String[] args) {
        Error error = new Error();
        error.show();

        Error error1 = new Error(true, 1, "error");
        error1.show();

    }
}
