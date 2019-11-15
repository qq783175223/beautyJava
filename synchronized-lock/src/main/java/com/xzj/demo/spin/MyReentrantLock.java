package com.xzj.demo.spin;

import java.util.concurrent.atomic.AtomicReference;

/**
 * Create by xuzhijun.online on 2019/11/15.
 * <p>
 * 利用自旋机制模拟一个可重入锁
 */
public class MyReentrantLock {

    private AtomicReference<Thread> owner = new AtomicReference<>();

    private int count;

    public void lock() {
        Thread currentThread = Thread.currentThread();
        if (owner.get() == currentThread) {
            count++;
            return;
        }
        while (!owner.compareAndSet(null, currentThread)) {

        }
    }

    public void unLock(){
        Thread currentThread = Thread.currentThread();
        if (owner.get() == currentThread){
            if (count > 0){
                count--;
                return;
            }
            owner.compareAndSet(currentThread, null);
        }
    }
}
