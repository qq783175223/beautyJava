package com.xzj.demo.reentrant;

/**
 * Create by xuzhijun.online on 2019/11/15.
 */
public class Main {

    public static void main(String[] args) {
        SynchronizedTest synchronizedTest = new SynchronizedTest();
        new Thread(synchronizedTest).start();
        new Thread(synchronizedTest).start();
        new Thread(synchronizedTest).start();


        ReentrantLockTest reentrantLockTest = new ReentrantLockTest();
        new Thread(reentrantLockTest).start();
        new Thread(reentrantLockTest).start();
        new Thread(reentrantLockTest).start();
    }
}
