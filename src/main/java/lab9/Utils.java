package main.java.lab9;

public class Utils {
    public static <T> void printArray(T[] array) {
        for (T t : array) {
            System.out.println(t);
        }
    }
}
