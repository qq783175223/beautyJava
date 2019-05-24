package com.xzj.signal;

import sun.misc.Signal;
import sun.misc.SignalHandler;

public class SignalTest {

    public static void main(String[] args) throws Exception {

        SignalHandler signalHandler = new SignalHandler() {
            @Override
            public void handle(Signal signal) {
                System.out.println("SignalHandler: " + signal);
            }
        };
        // 只有kill -9能够结束jvm进程，别的信号量只是发送给java进程处理，至于如何响应是程序代码决定的
        //能接受特定信号的前提是进程注册了该信号，JVM并没有注册所有的信号，对JVM注册了的信号，用户可以自定义响应事件
//        Signal.handle(new Signal("HUP"), signalHandler); // kill -1 PID
        Signal.handle(new Signal("INT"), signalHandler); // kill -2 PID
        // already used by VM or OS: SIGQUIT
        // Signal.handle(new Signal("QUIT"), signalHandler); // kill -3 PID
        Signal.handle(new Signal("ABRT"), signalHandler); // kill -6 PID
        // already used by VM or OS: SIGKILL
        // Signal.handle(new Signal("KILL"), signalHandler); // kill -9 PID
//        Signal.handle(new Signal("ALRM"), signalHandler); // kill -14 PID
        Signal.handle(new Signal("TERM"), signalHandler); // kill -15 PID

        for (int i = 0; i < 1000; i++) {
            Thread.sleep(1000);
            System.out.println(i);
        }
    }
}
