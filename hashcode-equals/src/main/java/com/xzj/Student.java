package com.xzj;

/**
 * Create by xuzhijun.online on 2019/5/20.
 */
public class Student {
    String name;
    int age;

    public Student(String name, int age) {
        this.name = name;
        this.age = age;
    }

    @Override
    public int hashCode() {
        return 1;
    }

    @Override
    public boolean equals(Object obj) {
        return this.name.equals(((Student)obj).name);
    }
}
