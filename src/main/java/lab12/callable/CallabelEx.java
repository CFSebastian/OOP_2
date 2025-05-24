package main.java.lab12.callable;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

public class CallabelEx {

    public static void main(String[] args) throws InterruptedException, ExecutionException {
        ExecutorService executorService = Executors.newFixedThreadPool(3);
        List<Callable<Integer>> list = new ArrayList<>();
        list.add(() -> "apple".length());
        list.add(() -> "ceva".length());
        list.add(() -> "orange".length());
        list.add(() -> "peach".length());

        List<Future<Integer>> result = executorService.invokeAll(list);

        for (Future<Integer> future : result) {
            System.out.println(future.get());
        }

        Runnable task = () -> System.out.println("runnable");
        executorService.submit(task);

        executorService.shutdown();

    }
}
