package com.xzj.thread;

/**
 * Create by xuzhijun.online on 2019/5/23.
 */
// Java program to illustrate the
// behaviour of notify() method
class Geek1 extends Thread {
    @Override
    public void run() {
        synchronized (this) {
            System.out.println
                    (Thread.currentThread().getName() + "...starts");
            try {
                this.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println
                    (Thread.currentThread().getName() + "...notified");
        }
    }
}

class Geek2 extends Thread {
    Geek1 geeks1;

    Geek2(Geek1 geeks1) {
        this.geeks1 = geeks1;
    }

    @Override
    public void run() {
        synchronized (this.geeks1) {
            System.out.println
                    (Thread.currentThread().getName() + "...starts");

            try {
                this.geeks1.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println
                    (Thread.currentThread().getName() + "...notified");
        }
    }
}

class Geek3 extends Thread {
    Geek1 geeks1;

    Geek3(Geek1 geeks1) {
        this.geeks1 = geeks1;
    }

    @Override
    public void run() {
        synchronized (this.geeks1) {
            System.out.println
                    (Thread.currentThread().getName() + "...starts");
//            this.geeks1.notify();
            this.geeks1.notifyAll();
            System.out.println
                    (Thread.currentThread().getName() + "...notified");
        }
    }
}

class NotifyAllTest {
    public static void main(String[] args) throws InterruptedException {

        Geek1 geeks1 = new Geek1();
        Geek2 geeks2 = new Geek2(geeks1);
        Geek3 geeks3 = new Geek3(geeks1);
        Thread t1 = new Thread(geeks1, "Thread-1");
        Thread t2 = new Thread(geeks2, "Thread-2");
        Thread t3 = new Thread(geeks3, "Thread-3");
        t1.start();
        t2.start();
        Thread.sleep(500);
        t3.start();
    }
}
