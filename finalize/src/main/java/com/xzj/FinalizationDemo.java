package com.xzj;

/**
 * Create by xuzhijun.online on 2019/12/1.
 */

public class FinalizationDemo {
    public static void main(String[] args) {
        Cake c1 = new Cake(1);
        Cake c2 = new Cake(2);
        Cake c3 = new Cake(3);

//        c1 = c3;

        c2 = c3 = null;
        System.gc(); //Invoke the Java garbage collector
//        System.runFinalizersOnExit(true);
    }
}

class Cake extends Object {
    private int id;
    public Cake(int id) {
        this.id = id;
        System.out.println("Cake Object " + id + " is created");
    }

    @Override
    protected void finalize() throws java.lang.Throwable {
        super.finalize();
        System.out.println("Cake Object " + id + " is disposed");
    }
}