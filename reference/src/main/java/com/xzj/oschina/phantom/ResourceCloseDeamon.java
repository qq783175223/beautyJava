package com.xzj.oschina.phantom;

import java.io.Closeable;
import java.lang.ref.Reference;
import java.lang.ref.ReferenceQueue;
import java.util.ArrayList;
import java.util.List;

public class ResourceCloseDeamon extends Thread {

    private static ReferenceQueue QUEUE = new ReferenceQueue();

    //保持对reference的引用,防止reference本身被回收
    private static List<Reference> references = new ArrayList<>();

    @Override
    public void run() {
        this.setName("ResourceCloseDeamon");
        while (true) {
            try {
                ResourcePhantomReference reference = (ResourcePhantomReference) QUEUE.remove();
                reference.cleanUp();
                references.remove(reference);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public static void register(Object referent, List<Closeable> closeables) {
        references.add(new ResourcePhantomReference(referent, QUEUE, closeables));
    }


}