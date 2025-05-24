package main.java.lab12.runnable;

import main.java.lab12.thread.ParalelThread;

public class Main {

    public static void main(String[] args) {
        System.out.println("[main] started");

        ParalelRunnable task1 = new ParalelRunnable("101");

        ParalelRunnable task2 = new ParalelRunnable("102");

        Thread thread1 = new Thread(task1);

        Thread thread2 = new Thread(task2);

        thread1.start();

        thread2.start();

        System.out.println("[main] enbd");
    }
}
