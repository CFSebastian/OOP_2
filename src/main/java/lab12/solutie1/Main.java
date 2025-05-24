package main.java.lab12.solutie1;



public class Main {
    public static void main(String[] args) throws InterruptedException {

        RaceCon race = new RaceCon();

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
