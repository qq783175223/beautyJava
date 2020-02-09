package com.xzj.gfg.strong;


// Java program to illustrate Strong reference
class Gfg
{
    //Code..
}
public class Example
{
    public static void main(String[] args)
    {
        //Strong Reference - by default
        Gfg g = new Gfg();

        //Now, object to which 'g' was pointing earlier is
        //eligible for garbage collection.
        g = null;
    }
}