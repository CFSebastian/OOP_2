package main.java.lab9;

import java.io.StringBufferInputStream;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        System.out.println(Beings.BIRD);

        System.out.println(Beings.BIRD.getDescription());


        Integer anInt = 10;
        Bucket<Integer> anIntBucket = new Bucket<>(anInt);
        System.out.println(anIntBucket.getContent());

        String anString = "abc";
        Bucket<String> anStrBucket = new Bucket<>(anString);
        System.out.println(anIntBucket.getContent());

        Integer[] anIntArray = new Integer[3];
        anIntArray[0] = 1;
        anIntArray[1] = 2;
        anIntArray[2] = 3;
        Utils.printArray(anIntArray);

        NumberBox<Integer> anIntBox = new NumberBox<>(Integer.parseInt("1"));
        System.out.println(anIntBox.getNumber());
        System.out.println(anIntBox.getDouble());

        /// //////////////////////////////////////////////////////////////
        String message = "Hello World";
        Package<String> letter = new Package<>(message,"add1");

        String message2 = "Hello World2";
        Package<String> letter2 = new Package<>(message2,"add12");

        //System.out.println(Util2.getType(letter));


        Queue<Package<String>> letters = new LinkedList<>();
        letters.add(letter);
        System.out.println(letters.toString());
        letters.add(letter2);
        System.out.println(letters.toString());
        letters.remove();
        System.out.println(letters.toString());

        LinkedHashMap<String,Integer> inventory = new LinkedHashMap<>();
        inventory.put("GPU",102);
        inventory.put("CPU",40);
        System.out.println(inventory.toString());
        inventory.put("GPU",101);
        System.out.println(inventory.toString());

        LinkedList<String> train = new LinkedList<>();
        train.add("Front");
        train.add("Cargo1");
        train.add("Back");
        train.set(2,"cargo2");
        System.out.println(train.toString());

        Set<String> keys = new HashSet<>();
        keys.add("Home");
        keys.add("Garage");
        keys.add("Car");
        keys.add("Car");
        System.out.println(keys);

        Deque<Integer> fitile = new LinkedList<>();
        fitile.add(1);
        fitile.add(2);



    }
}
