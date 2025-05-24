package main.java.lab12.thread;

public class Main {

    public static void main(String[] args) {
        System.out.println("[main] started");

        ParalelThread task1 = new ParalelThread("101");

        ParalelThread task2 = new ParalelThread("102");

        task1.start();

        task2.start();

        System.out.println("[main] enbd");
    }
}
