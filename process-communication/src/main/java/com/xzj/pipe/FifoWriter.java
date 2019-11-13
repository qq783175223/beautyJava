package com.xzj.pipe;

import java.io.*;

/**
 * Create by xuzhijun.online on 2019/11/13.
 */
public class FifoWriter {
    public static void main(String[] args) throws Exception{
        File pipe = new File("/root/java_demo/pipe/xuzhijun_pipe");

        BufferedWriter writer = new BufferedWriter(new FileWriter(pipe));

        writer.write("this is xuzhijun pipe test");
        writer.flush();

    }
}
