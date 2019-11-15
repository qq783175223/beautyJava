package com.xzj.demo.reentrantlock;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Create by xuzhijun.online on 2019/11/15.
 *
 * 使用ReentrantLock例子
 */
public class ReentrantLockExample3 {

    /**
     * output :     main thread
     *              thread one lock obtained
     *              java.lang.InterruptedException
     * 	                at java.util.concurrent.locks.AbstractQueuedSynchronizer.tryAcquireNanos(AbstractQueuedSynchronizer.java:1245)
     * 	                at java.util.concurrent.locks.ReentrantLock.tryLock(ReentrantLock.java:442)
     * 	                at com.xzj.demo.reentrantlock.ReentrantLockExample3$2.run(ReentrantLockExample3.java:45)
     * 	                at java.lang.Thread.run(Thread.java:748)
     *              thread one lock realsed
     * @param args
     */
    public static void main(String[] args) {

        ReentrantLock rlock =  new ReentrantLock(true);

        Thread threadOne = new Thread(new Runnable() {
            @Override
            public void run() {
                rlock.lock();
                try {
                    if(rlock.isHeldByCurrentThread()) {
                        System.out.println("thread one lock obtained");
                        Thread.sleep(5000);
                        System.out.println("thread one lock realsed");
                    }

                } catch (InterruptedException e) {	}
                finally {
                    if(rlock.isHeldByCurrentThread()) {
                        rlock.unlock();
                    }
                }
            }
        });
        Thread threadTwo = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    rlock.tryLock(5500, TimeUnit.MILLISECONDS);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                try {
                    if(rlock.isHeldByCurrentThread()) {
                        System.out.println("thread two lock obtained");
                    }
                }finally {
                    if(rlock.isHeldByCurrentThread()) {
                        rlock.unlock();
                    }
                }
            }
        });
        threadOne.start();
        threadTwo.start();
        threadTwo.interrupt();
        System.out.println("main thread");
    }
}
