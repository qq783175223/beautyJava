package com.xzj;

import java.util.ArrayList;
import java.util.List;

/**
 * Create by xuzhijun.online on 2019/11/12.
 */
public class Main {

    public static void main(String[] args) {
        List<? extends Number> foo3 = new ArrayList<Number>();

        List<?> list = new ArrayList<String>();
//        list.add("hello");

    }

    public <T> List<T> reduce(List<T> list){
        //do something
        return list;
    }

}
