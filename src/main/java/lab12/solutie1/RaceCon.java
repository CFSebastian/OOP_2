package main.java.lab12.solutie1;

public class RaceCon {

    private int val =0;

    public void increase() {
        synchronized (this) {
            val++;
        }
    }

    public int getVal() {

        return val;
    }
}
