package com.xzj.pipe;

import java.io.*;

/**
 * Create by xuzhijun.online on 2019/11/13.
 */
public class FifoReader {
    public static void main(String[] args) throws Exception{
        File pipe = new File("/root/java_demo/pipe/xuzhijun_pipe");

        BufferedReader reader = new BufferedReader(new FileReader(pipe));
//DataInputStream reader = new DataInputStream(new FileInputStream(pipe2));
        char [] buf = new char[64];
        reader.read(buf);
        System.out.println(String.valueOf(buf));
    }
}
