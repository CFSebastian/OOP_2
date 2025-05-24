package main.java.lab12.bank;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Main {
 public static void main(String[] args) throws InterruptedException {
     BankAc[] accounts = new BankAc[]{
             new BankAc("Sandu", 10),
             new BankAc("Ceva", 20),
             new BankAc("Sebi", 0),
             new BankAc("Sami", 10),
             new BankAc("Sam", 20)};
     ExecutorService executorService = Executors.newFixedThreadPool(10);
     List<Callable<Integer>> list = new ArrayList<>();
     for (int i = 0; i < 10; i++) {
         int threadId = i;
         list.add(() -> {
             accounts[threadId % 5].deposit(100);

             try {
                 Thread.sleep(1000);
             } catch (InterruptedException e) {
                 throw new RuntimeException(e);
             }

             accounts[threadId % 5].withdraw(50);
             return 0;//?
         });
     }
     executorService.invokeAll(list);


     for(BankAc a : accounts){
         System.out.println(a.getBalance());
     }
     executorService.shutdown();
 }
}
