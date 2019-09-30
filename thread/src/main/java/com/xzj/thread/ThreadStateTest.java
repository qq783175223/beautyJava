package com.xzj.thread;

/**
 * Create by xuzhijun.online on 2019/9/30.
 */
public class ThreadStateTest {
    public static void main(String[] args) throws InterruptedException {
        Thread t = new Thread(new Runnable() {
            @Override
            public void run() {
                Thread currentThread = Thread.currentThread();
                try {
                    System.out.println("sleep 150ms");
                    Thread.sleep(150);
                    System.out.println("sleep 结束");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                synchronized (currentThread) {
                    try {
                        System.out.println("wait线程");
                        currentThread.wait();
                        System.out.println("wait结束");
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                System.out.println(currentThread.getState());
                System.out.println("执行完成");
            }
        });
        //NEW
        System.out.println("当前线程状态" + t.getState());

        t.start();

        //TIMED_WAITING
        Thread.sleep(100);
        System.out.println("当前线程状态" + t.getState());

        Thread.sleep(200);
        System.out.println("当前线程状态" + t.getState());
        synchronized (t) {
            t.notify();
        }

        Thread.sleep(100);
        System.out.println("当前线程状态" + t.getState());
    }
}
