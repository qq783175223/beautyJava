package com.xzj;

/**
 * Create by xuzhijun.online on 2019/5/20.
 */
public class Boss {
    String name;
    int age;

    public Boss(String name, int age) {
        this.name = name;
        this.age = age;
    }

    @Override
    public int hashCode() {
        return super.hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        return this.name.equals(((Boss)obj).name);
    }
}
