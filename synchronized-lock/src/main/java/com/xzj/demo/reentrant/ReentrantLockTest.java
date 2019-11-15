package com.xzj.demo.reentrant;

import java.util.concurrent.locks.ReentrantLock;

/**
 * Create by xuzhijun.online on 2019/11/15.
 *
 * 测试ReentrantLock的可重入性
 */
public class ReentrantLockTest implements Runnable{
    ReentrantLock lock = new ReentrantLock();

    public void get(){
        lock.lock();
        System.out.println(Thread.currentThread().getId());
        set();
        lock.unlock();
    }
    public void set(){
        lock.lock();
        System.out.println(Thread.currentThread().getId());
        lock.unlock();
    }

    @Override
    public void run() {
        get();
    }
}
