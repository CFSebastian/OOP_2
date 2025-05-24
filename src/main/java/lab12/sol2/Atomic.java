package main.java.lab12.sol2;

import java.util.concurrent.atomic.AtomicInteger;

public class Atomic {
    private AtomicInteger val = new AtomicInteger(0);

    public void increase() {
        synchronized (this) {
            val.incrementAndGet();
        }
    }

    public int getVal() {

        return val.get();
    }
}
