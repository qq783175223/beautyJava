package com.xzj.oschina.phantom;

import java.io.Closeable;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;


/**
 * PhantomReference主要作为其指向的referent被回收时的一种通知机制,它就是利用上文讲到的ReferenceQueue实现的。
 * 当referent被gc回收时，JVM自动把PhantomReference对象(reference)本身加入到ReferenceQueue中，像发出信号通知一样，表明该reference指向的referent被回收。
 * 然后可以通过去queue中取到reference，此时说明其指向的referent已经被回收，可以通过这个通知机制来做额外的清场工作。
 * 因此有些情况可以用PhantomReference 代替finalize()，做资源释放更明智。
 */

public class PhantomTest {

    public static void main(String[] args) throws Exception {
        //打开回收
        ResourceCloseDeamon deamon = new ResourceCloseDeamon();
        deamon.setDaemon(true);
        deamon.start();

        // touch a.txt b.txt
        // echo "hello" > a.txt
        //保留对象,防止gc把stream回收掉,其不到演示效果
        List<Closeable> all=new ArrayList<>();
        FileInputStream inputStream;
        FileOutputStream outputStream;

        for (int i = 0; i < 100000; i++) {
            inputStream = new FileInputStream("/root/java_demo/a.txt");
            outputStream = new FileOutputStream("/root/java_demo/b.txt");
            FileOperation operation = new FileOperation(inputStream, outputStream);
            operation.operate();
            TimeUnit.MILLISECONDS.sleep(100);

            List<Closeable> closeables = new ArrayList<>();
            closeables.add(inputStream);
            closeables.add(outputStream);
            all.addAll(closeables);

            ResourceCloseDeamon.register(operation, closeables);
            //用下面命令查看文件句柄,如果把上面register注释掉,就会发现句柄数量不断上升
            //jps | grep PhantomTest | awk '{print $1}' |head -1 | xargs  lsof -p  | grep /User/robin

            //下一次循环的时候才能gc掉上一次的FileOperation对象
            //会gc掉上一次创建的FileOperation对象，但是不会gc FileInputStream/FileOutputStream, 因为FileInputStream/FileOutputStream一直被all引用
            System.gc();

            System.out.println(System.currentTimeMillis());

        }


    }
}