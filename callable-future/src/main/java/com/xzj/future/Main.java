package com.xzj.future;

import java.util.concurrent.Callable;

/**
 * Create by xuzhijun.online on 2019/11/11.
 */
public class Main {

    public static void main(String[] args) {
        Callable<String> callable = new Callable<String>() {
            @Override
            public String call() throws Exception {
                // Perform some computation
                Thread.sleep(2000);
                return "Return some result";
            }
        };

        //run方法没有抛出异常，需要try/catch
        new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        };
    }

}
