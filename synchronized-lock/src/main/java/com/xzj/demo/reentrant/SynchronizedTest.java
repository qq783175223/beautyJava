package com.xzj.demo.reentrant;

/**
 * Create by xuzhijun.online on 2019/11/15.
 *
 * 测试synchronized 的可重入性
 *
 */
public class SynchronizedTest implements Runnable{

    public synchronized void get(){
        System.out.println(Thread.currentThread().getId());
        set();
    }

    public synchronized void set(){
        System.out.println(Thread.currentThread().getId());
    }


        @Override
    public void run() {
            get();
        }
}
