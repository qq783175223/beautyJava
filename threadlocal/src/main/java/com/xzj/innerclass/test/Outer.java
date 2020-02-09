package com.xzj.innerclass.test;


public class Outer {

    private static String outerStatic = "outer";
    private String outer = "outer";


    Inner4 getInstance4(){
        return new Inner4();
    }


    static class Inner1{

        private String get(){
            return "hello world, i am static class Inner1";
        }

        void print(){
            System.out.println(Outer.outerStatic);
            //非静态内部类在编译完成之后会隐含地保存着一个引用，该引用是指向创建它的外围内，但是静态内部类却没有。
            //System.out.println(outer);
        }

    }

    class Inner4{

        //非静态类不能定义static成员，除非final修饰
        //static String  innerClassString = "dd";
        static final String  innerClassString = "dd";

        String get(){
            return "hello world, i am class Inner4";
        }

        void print(){
            System.out.println(Outer.outerStatic);
            // 内部类可以直接访问外部类成员，原因在于隐式持有了一个外部类引用
            System.out.println(outer);
            // Outer.this 就是内部类隐式持有的外部类引用
            System.out.println(Outer.this.outer);
        }
    }

    private static class Inner2{

        private String get(){
            return "hello world, i am static class Inner2";
        }
    }

    static class Inner3{

        String get(){
            return "hello world, i am static class Inner3";
        }
    }



}
