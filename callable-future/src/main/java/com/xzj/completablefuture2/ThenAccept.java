package com.xzj.completablefuture2;

import java.util.Random;
import java.util.concurrent.CompletableFuture;
import java.util.function.Supplier;

public class ThenAccept {
    public static void thenAccept() throws Exception{
        CompletableFuture<Void> future = CompletableFuture.supplyAsync(new Supplier<Integer>() {
            @Override
            public Integer get() {
                return new Random().nextInt(10);
            }
        }).thenAccept(integer -> {
            System.out.println(integer);
        });
        Void aVoid = future.get();
        System.out.println(aVoid);
    }

    public static void main(String[] args) throws Exception {
        thenAccept();
    }
}
