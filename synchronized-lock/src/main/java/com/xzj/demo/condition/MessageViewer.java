package com.xzj.demo.condition;

/**
 * Create by xuzhijun.online on 2019/11/15.
 */
public class MessageViewer implements Runnable{
    private Message message;

    public MessageViewer(Message msg) {
        message = msg;
    }

    @Override
    public void run() {
        while(!message.isEndIt()){
            message.viewMessage();
        }
    }
}