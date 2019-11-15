package com.xzj.demo.condition;

/**
 * Create by xuzhijun.online on 2019/11/15.
 */
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Message {

    final private Lock lock = new ReentrantLock();
    final private Condition producedMsg  = lock.newCondition();
    final private Condition consumedMsg = lock.newCondition();

    private String message;
    private boolean messageState;
    private boolean endIt;

    public void viewMessage() {
        //lock
        lock.lock();
        try {
            //no new message wait for new message
            while (!messageState) {
                producedMsg.await();
            }

            System.out.println("Here is the latest message : "+message);
            messageState = false;
            //message consumed, notify waiting thread
            consumedMsg.signal();

        }catch(InterruptedException ie) {
            System.out.println("Thread interrupted - viewMessage");
        }finally {
            lock.unlock();
        }
    }
    public void publishMessage(String message) {
        lock.lock();
        try {
            //last message not consumed, wait for it be consumed
            while (messageState)
                consumedMsg.await();

            System.out.println("adding latest message ");
            this.message = message;
            messageState = true;
            //new message added, notify waiting thread
            producedMsg.signal();

        }catch(InterruptedException ie) {
            System.out.println("Thread interrupted - publishMessage");
        }finally {
            lock.unlock();
        }

    }

    public boolean isEndIt() {
        return endIt;
    }
    public void setEndIt(boolean endIt) {
        this.endIt = endIt;
    }
}