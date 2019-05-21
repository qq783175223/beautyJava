package com.xzj;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;

/**
 * Create by xuzhijun.online on 2019/5/21.
 */
public class MyAtomicInteger extends AtomicInteger {
    private AtomicLong failureCount = new AtomicLong(0);

    public long getFailureCount() {
        return failureCount.get();
    }

    /**
     * 从以下两个方法 inc 和 dec 可以看出 Atomic* 的原子性的实现原理：
     * 这是一种乐观锁，每次修改值都会【先比较再赋值】，这个操作在CPU层面是原子的，从而保证了其原子性。
     * 如果比较发现值已经被其他线程变了，那么就返回 false，然后重新尝试。
     */
    public void inc() {
        Integer value;
        do {
            value = get();
            failureCount.getAndIncrement();
//            try {
//                TimeUnit.MILLISECONDS.sleep(2);
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
        } while (!compareAndSet(value, value + 1));
    }

    public void dec() {
        Integer value;
        do {
            value = get();
            failureCount.getAndIncrement();
//            try {
//                TimeUnit.MILLISECONDS.sleep(2);
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
        } while (!compareAndSet(value, value - 1));
    }
}