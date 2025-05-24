package main.java.lab12.chatRoom;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        ExecutorService executorService = Executors.newFixedThreadPool(3);
        Post[] posts = new Post[]{
                    new Post("Sandu", "hello"),
                    new Post("Sandu", "20"),
                    new Post("Sebi", "nu"),
                    new Post("Sami", "da"),
                    new Post("Sebi", "nu")
        };
        List<Post> chat = new CopyOnWriteArrayList<>();
        List<Callable<Integer>> list = new ArrayList<>();
        for (Post post : posts) {
            list.add(() -> {chat.add(post); return 0;});
        }
        executorService.invokeAll(list);
        for (Post post : chat) {
            post.printPost();
        }
        executorService.shutdown();
    }
}
