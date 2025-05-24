package main.java.lab12.sol2;


public class Main {
    public static void main(String[] args) throws InterruptedException {

        Atomic race = new Atomic();

        Thread t1 = new Thread() {
            @Override
            public void run() {
                for (int i = 0; i < 1000; i++) {
                    race.increase();
                }
            }
        };
        Thread t2 = new Thread() {
            @Override
            public void run() {
                for (int i = 0; i < 1000; i++) {
                    race.increase();
                }
            }
        };

        t2.start();
        t1.start();

        t1.join();
        t2.join();

    }
}
