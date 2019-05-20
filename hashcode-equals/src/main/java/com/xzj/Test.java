package com.xzj;

import java.util.HashMap;

/**
 * Create by xuzhijun.online on 2019/5/20.
 */
public class Test {
    public static void main(String[] args) {

        /**
         * hashcode: 不相等
         * equals: 不相等
         * map.size = 2
         */
//        User user1 = new User("user1", 44);
//        User user2 = new User("user2", 55);
//
//        System.out.println(user1.hashCode());
//        System.out.println(user2.hashCode());
//
//        System.out.println(user1 == user2);
//        System.out.println(user1.equals(user2));
//
//        HashMap map1 = new HashMap();
//        map1.put(user1,"this is a test");
//        map1.put(user2,"this is a test");
//
//        System.out.println(map1.size());

        /**
         * hashcode: 相等
         * equals: 不相等
         * map.size = 2
         */
//        Student stu1 = new Student("张三", 22);
//        Student stu2 = new Student("李四", 23);
//
//        System.out.println(stu1.hashCode());
//        System.out.println(stu2.hashCode());
//
//        System.out.println(stu1 == stu2);
//        System.out.println(stu1.equals(stu2));
//
//        HashMap map2 = new HashMap();
//        map2.put(stu1,"this is a test");
//        map2.put(stu2,"this is a test");
//
//        System.out.println(map2.size());

        /**
         * hashcode: 相等
         * equals: 相等
         * map.size = 1
         */
//        Student stu3 = new Student("张三", 22);
//        Student stu4 = new Student("张三", 23);
//
//        System.out.println(stu3.hashCode());
//        System.out.println(stu4.hashCode());
//
//        System.out.println(stu3 == stu4);
//        System.out.println(stu3.equals(stu4));
//
//        HashMap map4 = new HashMap();
//        map4.put(stu3,"this is a test");
//        map4.put(stu4,"this is a test");
//
//        System.out.println(map4.size());

        /**
         * hashcode: 不相等
         * equals: 相等
         * map.size = 2
         */
        Boss boss1 = new Boss("张三", 22);
        Boss boss2 = new Boss("张三", 23);

        System.out.println(boss1.hashCode());
        System.out.println(boss2.hashCode());

        System.out.println(boss1 == boss2);
        System.out.println(boss1.equals(boss2));

        HashMap map3 = new HashMap();
        map3.put(boss1,"this is a test");
        map3.put(boss2,"this is a test");

        System.out.println(map3.size());
    }
}
