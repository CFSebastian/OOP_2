package main.java.lab8;

import java.util.ArrayList;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        ArrayList<Ceva>  list = new ArrayList<>();
        Ceva[] arr = new Ceva[]{
                new Ceva("a",2,3),
                new Ceva("b",4,3),
                new Ceva("v",7,8),
                new Ceva("d",9,6),
                new Ceva("s",1,9),
                new Ceva("j",8,3),
                new Ceva("a",2,3),
                new Ceva("m",8,2)
        };

        for (Ceva e : arr) {
            list.add(e);
        }

        list.stream().limit(5)
                .map(x -> Integer.parseInt(x.getName()))
                .distinct()
                .limit(2)
                .collect(Collectors.toList())
                .forEach(System.out::println);


    }
}
