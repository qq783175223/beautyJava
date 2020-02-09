package com.xzj.oschina.reference;

import java.lang.ref.*;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * 为了确保System.gc()后,SoftReference引用的referent被回收需要加入下面的参数
 * -XX:SoftRefLRUPolicyMSPerMB=0
 */
public class ReferenceTest {

    private static List<Reference> roots = new ArrayList<>();

    public static void main(String[] args) throws Exception {

        ReferenceQueue rq = new ReferenceQueue();

        new Thread(new Runnable() {
            @Override
            public void run() {
                int i = 0;
                while (true) {
                    try {
                        Reference r = rq.remove();
                        System.out.println("reference:" + r);
                        //为null说明referent被回收
                        System.out.println("get:" + r.get());
                        i++;
                        System.out.println("queue remove num:" + i);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }).start();


        for (int i = 0; i < 100000; i++) {
            byte[] a = new byte[1024 * 1024];
            // 分别验证SoftReference,WeakReference,PhantomReference
//            Reference r = new SoftReference(a, rq);
            Reference r = new WeakReference(a, rq);
//            Reference r = new PhantomReference(a, rq);
            System.out.println("**** = " + r.get());
            roots.add(r);
            System.gc();

            System.out.println("produce" + i);
            TimeUnit.MILLISECONDS.sleep(100);
        }
    }

}