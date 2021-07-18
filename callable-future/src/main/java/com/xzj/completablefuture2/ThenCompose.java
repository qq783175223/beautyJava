package com.xzj.completablefuture2;

import java.util.Random;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.CompletionStage;
import java.util.function.Function;
import java.util.function.Supplier;

public class ThenCompose {
    private static void thenCompose() throws Exception {
        CompletableFuture<String> f = CompletableFuture.supplyAsync(new Supplier<Integer>() {
            @Override
            public Integer get() {
                int t = new Random().nextInt(10);
                System.out.println("t1="+t);
                return t;
            }
        }).thenCompose(new Function<Integer, CompletionStage<String>>() {
            @Override
            public CompletionStage<String> apply(Integer param) {
                return CompletableFuture.supplyAsync(new Supplier<String>() {
                    @Override
                    public String get() {
                        int t = param *2;
                        System.out.println("t2="+t);
                        return t +"";
                    }
                });
            }

        });
        System.out.println("thenCompose result : "+f.get());
    }

    public static void main(String[] args) throws Exception {
        thenCompose();
    }
}
