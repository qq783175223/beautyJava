package com.xzj.oschina.phantom;

import java.io.Closeable;
import java.io.IOException;
import java.lang.ref.PhantomReference;
import java.lang.ref.ReferenceQueue;
import java.util.List;

public class ResourcePhantomReference<T> extends PhantomReference<T> {

    private List<Closeable> closeables;

    public ResourcePhantomReference(T referent, ReferenceQueue<? super T> q, List<Closeable> resource) {
        super(referent, q);
        closeables = resource;
    }

    public void cleanUp() {
        if (closeables == null || closeables.size() == 0)
            return;
        for (Closeable closeable : closeables) {
            try {
                closeable.close();
                System.out.println("clean up:" + closeable);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}