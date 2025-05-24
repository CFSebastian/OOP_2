package main.java.lab12.chatRoom;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Post {
    private String name;
    private String message;
    private int postDate;
    private static int date=0;

    public Post(String name, String message) {
        this.name = name;
        this.message = message;
        this.postDate = date;
        date++;
    }
    public void printPost(){
        System.out.println(message + " | " + name + " | " + postDate);
    }
}
