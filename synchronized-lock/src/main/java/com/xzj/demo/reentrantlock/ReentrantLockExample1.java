package com.xzj.demo.reentrantlock;

import java.util.concurrent.locks.ReentrantLock;

/**
 * Create by xuzhijun.online on 2019/11/15.
 *
 * 使用ReentrantLock例子
 */
public class ReentrantLockExample1 {

    /**
     * output :  main thread
     *           thread one lock obtained
     *           thread two lock obtained
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
                rlock.lock();
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
        System.out.println("main thread");
    }
}
