package main.java.lab9;

import java.util.HashMap;
import java.util.Map;

public class Collections {
    public static void main(String[] args) {
        HashMap<String,Integer> aMap = new HashMap<String,Integer>();

        aMap.put("a",1);
        System.out.println(aMap);
        aMap.put("a",2);
        System.out.println(aMap);
        System.out.println(aMap.get("a"));
        aMap.containsKey("a");
    }
}
