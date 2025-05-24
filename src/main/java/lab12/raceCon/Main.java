package main.java.lab12.raceCon;

public class Main {

    public static void main(String[] args) {

        RaceCondition race = new RaceCondition();

        Thread t1 = new Thread() {
            @Override
            public void run() {
                race.increase();
            }
        };
        Thread t2 = new Thread() {
            @Override
            public void run() {
                race.increase();
            }
        };

        t2.start();
        t1.start();

    }
}
