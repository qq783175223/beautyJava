package com.xzj.erasure;

/**
 * Create by xuzhijun.online on 2019/11/14.
 *
 * 泛型类型擦除
 */
public class Erasure1<T>{
    T object;

    public Erasure1(T object) {
        this.object = object;
    }

    public <T extends String>  void add(T object){

    }

}