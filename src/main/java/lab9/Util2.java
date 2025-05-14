package main.java.lab9;

import java.util.List;

public class Util2 {
    public static  void getType(List<? extends Object>  list){
       for(Object o:list){
           System.out.println(o);
       }
    }
}
