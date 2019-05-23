package com.xzj.sharememory;

/**
 * Create by xuzhijun.online on 2019/5/23.
 */

import java.io.RandomAccessFile;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.channels.FileLock;
import java.nio.channels.FileChannel.MapMode;

public class NIOReadLock {
    private static RandomAccessFile raf;

    public static void main(String[] args) throws Exception {

        raf = new RandomAccessFile("D:/data.dat", "rw");
        FileChannel fc = raf.getChannel();
        MappedByteBuffer mbb = fc.map(MapMode.READ_WRITE, 0, 1024);
        FileLock flock = null;

        for (int i = 0; i < 26; i++) {
            flock = fc.lock();    //上锁
            System.out.println(System.currentTimeMillis() + "-read:" + (char) mbb.get(i));
            flock.release();    //释放锁
            Thread.sleep(1000);
        }
    }
}