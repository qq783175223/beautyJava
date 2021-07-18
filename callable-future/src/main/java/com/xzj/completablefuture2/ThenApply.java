package com.xzj.completablefuture2;

import java.util.Random;
import java.util.concurrent.CompletableFuture;
import java.util.function.Function;
import java.util.function.Supplier;

public class ThenApply {
    private static void thenApply() throws Exception {
        CompletableFuture<String> future = CompletableFuture.supplyAsync(new Supplier<Long>() {
            @Override
            public Long get() {
                long result = new Random().nextInt(100);
                System.out.println("result1="+result);
                return result;
            }
        }).thenApply(new Function<Long, String>() {
            @Override
            public String apply(Long t) {
                long result = t*5;
                System.out.println("result2="+result);
                return result +"";
            }
        });

        String result = future.get();
        System.out.println(result);
    }

    public static void main(String[] args) throws Exception {
        thenApply();
    }
}
