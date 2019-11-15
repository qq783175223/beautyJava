package com.xzj.demo.condition;

/**
 * Create by xuzhijun.online on 2019/11/15.
 */
public class Main {
    public static void main(String[] args) {

        Message msg = new Message();
        Thread messageProducer = new Thread(new MessageProducer(msg));
        Thread messageViewer = new Thread(new MessageViewer(msg));
        messageProducer.start();
        messageViewer.start();

    }
}
