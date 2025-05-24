package main.java.lab12.runnable;

public class ParalelRunnable implements Runnable {
    private String orderId;

    public ParalelRunnable(String orderId) {
        this.orderId = orderId;
    }

    @Override
    public void run() {
        System.out.println("[thread] started: " + orderId);

        try{
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw  new RuntimeException(e);
        }

        System.out.println("[thread] finished: " + orderId);
    }
}
