package com.xzj.completablefuture2;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.TimeUnit;

public class Test1 {
    //无返回值
    public static void runAsync() throws Exception {
        CompletableFuture<Void> future = CompletableFuture.runAsync(() -> {
            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
            }
            System.out.println("run end ...");
        });

        Void aVoid = future.get();
        System.out.println(aVoid);
    }

    //有返回值
    public static void supplyAsync() throws Exception {
        CompletableFuture<Long> future = CompletableFuture.supplyAsync(() -> {
            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
            }
            System.out.println("run end ...");
            return System.currentTimeMillis();
        });

        long time = future.get();
        System.out.println("time = "+time);
    }

    public static void main(String[] args) throws Exception {
        //runAsync();
        supplyAsync();
    }
}
