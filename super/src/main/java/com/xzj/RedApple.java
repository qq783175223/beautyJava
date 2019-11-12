package com.xzj;

/**
 * Create by xuzhijun.online on 2019/11/12.
 */
public class RedApple extends Apple{

    public RedApple(){
        //需要指定父类构造器，否则找不到父类的无参默认构造器而编译报错
        super("red");
    }

}
