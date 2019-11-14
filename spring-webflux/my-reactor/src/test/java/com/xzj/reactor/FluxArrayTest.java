package com.xzj.reactor;

import org.junit.Test;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

import static org.junit.Assert.*;

/**
 * Create by xuzhijun.online on 2019/5/25.
 */
public class FluxArrayTest {
    @Test
    public void fluxArrayTest() {
        Flux.just(1, 2, 3, 4, 5).subscribe(new Subscriber<Integer>() { // 1

            @Override
            public void onSubscribe(Subscription s) {
                System.out.println("onSubscribe");
                s.request(3);   // 2
            }

            @Override
            public void onNext(Integer integer) {
                System.out.println("onNext:" + integer);
            }

            @Override
            public void onError(Throwable t) {

            }

            @Override
            public void onComplete() {
                System.out.println("onComplete");
            }
        });
    }

    @Test
    public void lambdaSubscriberTest() {
        Flux.just(1, 2, 3, 4, 5)
                .map(i -> i * 2)
                .subscribe(
                        System.out::println,
                        System.err::println,
                        () -> System.out.println("Completed.")
//                        ,subscription -> subscription.request(3)
                );
    }
}