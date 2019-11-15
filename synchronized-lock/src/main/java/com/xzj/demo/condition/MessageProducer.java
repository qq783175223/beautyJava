package com.xzj.demo.condition;

import java.util.ArrayList;
import java.util.List;

/**
 * Create by xuzhijun.online on 2019/11/15.
 */
public class MessageProducer implements Runnable {
    private Message message;

    public MessageProducer(Message msg) {
        message = msg;
    }

    @Override
    public void run() {
        pusblishMessages();
    }

    private void pusblishMessages(){
        List<String> msgs = new ArrayList<String>();
        msgs.add("hello");
        msgs.add("current project is complete");
        msgs.add("here is the estimation for new project");

        for(String msg :  msgs) {
            message.publishMessage(msg);
            try {
                Thread.sleep(400);
            } catch (InterruptedException e) {}
        }

        message.publishMessage("bye");
        message.setEndIt(true);
    }
}