package com.xzj.reactor;

import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

/**
 * Create by xuzhijun.online on 2019/5/25.
 */
public class FluxArray<T> extends Flux<T> {
    private T[] array;  // 1

    public FluxArray(T[] data) {
        this.array = data;
    }

    @Override
    public void subscribe(Subscriber<? super T> actual) {
        actual.onSubscribe(new ArraySubscription<>(actual, array)); // 2
    }

    static class ArraySubscription<T> implements Subscription { // 1
        final Subscriber<? super T> actual;
        final T[] array;    // 2
        int index;
        boolean canceled;

        public ArraySubscription(Subscriber<? super T> actual, T[] array) {
            this.actual = actual;
            this.array = array;
        }

        @Override
        public void request(long n) {
            if (canceled) {
                return;
            }
            long length = array.length;
            for (int i = 0; i < n && index < length; i++) {
                actual.onNext(array[index++]);  // 3
            }
            if (index == length) {
                actual.onComplete();    // 4
            }
        }

        @Override
        public void cancel() {  // 5
            this.canceled = true;
        }
    }
}
