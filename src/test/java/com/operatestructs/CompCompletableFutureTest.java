package com.operatestructs;

import java.util.concurrent.CompletableFuture;

public class CompCompletableFutureTest {

    public static void main(String[] args) {
        CompletableFuture<String> ff = CompletableFuture.completedFuture("1");

        System.out.println("begin~");
        CompletableFuture.runAsync(() -> {
            String s = hello("小张");
            System.out.println(s);
        });

        CompletableFuture<Integer> f = CompletableFuture.supplyAsync(() -> {
            return 100;
        });
        f.thenAccept(System.out::println);

        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("complete!");
    }

    private static String hello(String name) {
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return "hello," + name;
    }
}
