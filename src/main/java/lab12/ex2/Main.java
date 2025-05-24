package main.java.lab12.ex2;

import main.java.lab9.Collections;

import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

public class Main {
    public static void main(String[] args) throws InterruptedException {

       // List<Integer>  list = new ArrayList<>();
        List<Integer>  list = new CopyOnWriteArrayList<>();

        //List<Integer>  list = Collections.synchronizedList(list);

        Thread t1 = new Thread() {
            @Override
            public void run() {
                for (int i = 0; i < 1000; i++) {
                    list.add(i);
                }
            }
        };
        Thread t2 = new Thread() {
            @Override
            public void run() {
                for (int i = 0; i < 1000; i++) {
                    list.add(i);
                }
            }
        };

        t2.start();
        t1.start();

        t1.join();
        t2.join();

        System.out.println(list.size());

    }
}
