package com.xzj.gfg.phantom;

//Code to illustrate Phantom reference
import java.lang.ref.*;
class Gfg
{
    //code
    public void x()
    {
        System.out.println("GeeksforGeeks");
    }
}

public class Example
{
    public static void main(String[] args)
    {
        //Strong Reference
        Gfg g = new Gfg();
        g.x();

        //Creating reference queue
        ReferenceQueue<Gfg> refQueue = new ReferenceQueue<Gfg>();

        //Creating Phantom Reference to Gfg-type object to which 'g'
        //is also pointing.
        PhantomReference<Gfg> phantomRef = null;

        phantomRef = new PhantomReference<Gfg>(g,refQueue);

        //Now, Gfg-type object to which 'g' was pointing
        //earlier is available for garbage collection.
        //But, this object is kept in 'refQueue' before
        //removing it from the memory.
        g = null;

        //It always returns null.
        g = phantomRef.get();

        //It shows NullPointerException.
        g.x();
    }
}