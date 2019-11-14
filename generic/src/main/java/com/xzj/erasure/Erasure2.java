package com.xzj.erasure;

/**
 * Create by xuzhijun.online on 2019/11/14.
 *
 * 泛型类型擦除
 */
public class Erasure2 <T extends String>{

    T object;

    public Erasure2(T object) {
        this.object = object;
    }

}