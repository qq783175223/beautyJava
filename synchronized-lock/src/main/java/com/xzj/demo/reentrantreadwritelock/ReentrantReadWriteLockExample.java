package com.xzj.demo.reentrantreadwritelock;

import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * Create by xuzhijun.online on 2019/11/15.
 *
 * 写锁释放后，读线程集合、其他写线程有机会获得锁
 *
 * 读锁全部释放后，写线程才能获得写锁
 *
 *
 */
public class ReentrantReadWriteLockExample {


    /**
     * output1 :    main thread
     *              thread write two lock obtained
     *              iphone
     *              iphone
     *              thread write one lock obtained
     *
     * output2:     main thread
     *              thread write one lock obtained
     *              thread write two lock obtained
     *              iphone
     *              iphone
     *
     * output2:     main thread
     *              thread write two lock obtained
     *              thread write one lock obtained
     *              iphone
     *              iphone
     *
     * @param args
     */
    public static void main(String[] args) {

        //instantiate share object
        ShoppingCart scart = new ShoppingCart();
        scart.addProduct("iphone");

        //instantiate ReentrantReadWriteLock
        ReentrantReadWriteLock rrwlock = new ReentrantReadWriteLock();

        Thread threadRead1 = new Thread(new Runnable() {
            @Override
            public void run() {
                ReentrantReadWriteLock.ReadLock rl = rrwlock.readLock();
                try {
                    //obtain read lock, so that no write occur during reading
                    rl.lock();
                    //read from shared object
                    System.out.println(scart.getProduct(0));
                    Thread.sleep(4000);
                } catch (InterruptedException e) {	}
                finally {
                    //release read lock
                    rl.unlock();
                }
            }
        });
        Thread threadRead2 = new Thread(new Runnable() {
            @Override
            public void run() {
                ReentrantReadWriteLock.ReadLock rl = rrwlock.readLock();
                try {
                    //obtain read lock, so that no write occur during reading
                    rl.lock();
                    //read from shared object
                    System.out.println(scart.getProduct(0));
                    Thread.sleep(5000);
                } catch (InterruptedException e) {	}
                finally {
                    //release read lock
                    rl.unlock();
                }
            }
        });
        Thread threadWrite1 = new Thread(new Runnable() {
            @Override
            public void run() {
                //get write lock
                //lock() block current thread till it acquires write lock
                //if you don't want to block current thread, use tryLock()
                rrwlock.writeLock().lock();
                try {
                    //if tryLock() is used, check if write lock is obtained
                    if(rrwlock.isWriteLockedByCurrentThread()) {
                        //write to shared object
                        scart.addProduct("pixel");
                        System.out.println("thread write one lock obtained");
                        Thread.sleep(3000);
                    }
                }catch (InterruptedException e) {	}
                finally {
                    if(rrwlock.isWriteLockedByCurrentThread()) {
                        //release or unlock write lock
                        rrwlock.writeLock().unlock();
                    }
                }
            }
        });
        Thread threadWrite2 = new Thread(new Runnable() {
            @Override
            public void run() {
                //get write lock
                //lock() block current thread till it acquires write lock
                //if you don't want to block current thread, use tryLock()
                rrwlock.writeLock().lock();
                try {
                    //if tryLock() is used, check if write lock is obtained
                    if(rrwlock.isWriteLockedByCurrentThread()) {
                        //write to shared object
                        scart.addProduct("pixel");
                        System.out.println("thread write two lock obtained");
                        Thread.sleep(2000);
                    }
                }catch (InterruptedException e) {	}
                finally {
                    if(rrwlock.isWriteLockedByCurrentThread()) {
                        //release or unlock write lock
                        rrwlock.writeLock().unlock();
                    }
                }
            }
        });

        threadWrite1.start();
        threadWrite2.start();
        threadRead1.start();
        threadRead2.start();

        System.out.println("main thread");
    }
}
