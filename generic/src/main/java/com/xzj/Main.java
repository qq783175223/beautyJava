package com.xzj;

import java.util.ArrayList;
import java.util.List;

/**
 * Create by xuzhijun.online on 2019/11/12.
 */
public class Main {

    public static void main(String[] args) {

        /**
         * 不能添加任何数据，编译报错
         * 因为foo3可能是Number自身或者Integer/Float/Long等所有可能的Number子类
         * 因此，放入任何类型都不准确
         */
        List<? extends Number> foo3 = new ArrayList<>();
        //编译报错
//        foo3.add(1);
//        foo3.add(1.2);
//        foo3.add(10L);


        /**
         * 只能添加Integer类型数据
         * 因为foo4可能是Integer自身或者所有Integer的父类
         * 唯一能确定的是可以将Integer类型赋值给这些可能存在的类型
         * 因此，只能放入Integer类型
         */
        List<? super Integer> foo4 = new ArrayList<>();
        //正确
        foo4.add(2);
        //编译不通过
//        foo4.add(2.2);
        //编译不通过
//        foo4.add(22L);

        /**
         * 不能添加任何数据
         * list1、list2被定义成可能是任何类型
         * 因此，放入任何类型的数据都不准确
         */
        List<?> list1 = new ArrayList<String>();
        //编译报错
//        list1.add("hello");
        List<?> list2 = new ArrayList<>();
        //编译报错
//        list2.add(2);
        //编译报错
//        list2.add("ds");

        //基本数据数组类型作为一个对象
        int[] myArray = { 1, 2, 3 };
        print1(myArray);

        int num = 22;
        print2(num);



    }


    public static <T> void print1(T... t) {
        for (T element: t){
            System.out.println(element);
        }
    }
    public static <T> void print2(T t) {
        System.out.println(t);
    }


}
