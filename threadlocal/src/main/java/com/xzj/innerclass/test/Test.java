package com.xzj.innerclass.test;

public class Test {

    public static void main(String[] args) {

        Outer outer = new Outer();

        //只能持有类对象，不能访问private方法
        Outer.Inner1 inner1 = new Outer.Inner1();

        //没有访问Outer.Inner2的权限

        //持有类对象，并且能访问defalut方法
        Outer.Inner3 inner3 = new Outer.Inner3();
        inner3.get();

        //持有类对象，并且能访问defalut方法
        Outer.Inner4 inner4 = outer.getInstance4();
        System.out.println(inner4.get());
    }
}
