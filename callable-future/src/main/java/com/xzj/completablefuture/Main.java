package com.xzj.completablefuture;

import java.util.Random;
import java.util.concurrent.CompletableFuture;

/**
 * Create by xuzhijun.online on 2019/11/11.
 */
public class Main {

    public static void main(String[] args) throws Exception {
        Random rand = new Random();
        CompletableFuture<Integer> future1 = CompletableFuture.supplyAsync(() -> {
            try {
                Thread.sleep(1000 + rand.nextInt(1000));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            return 100;
        });
        CompletableFuture<String> future2 = CompletableFuture.supplyAsync(() -> {
            try {
                Thread.sleep(1000 + rand.nextInt(1000));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            return "abc";
        });
        CompletableFuture<Void> f = CompletableFuture.allOf(future1, future2);
//        CompletableFuture<Object> f = CompletableFuture.anyOf(future1, future2);
        System.out.println(f.get());
    }
}