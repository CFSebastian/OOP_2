package main.java.lab5;

public class InvalidProductPrice extends RuntimeException {
    public InvalidProductPrice(String message) {
        super(message);
    }
}
