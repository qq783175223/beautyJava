package com.xzj.erasure;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

/**
 * Create by xuzhijun.online on 2019/11/14.
 */
public class ToolTest {


    /**
     * output:  23
     *          test
     *          42.9
     * @param args
     */
    public static void main(String[] args) {
        List<Integer> ls = new ArrayList<>();
        ls.add(23);
//		ls.add("text");
        try {
            Method method = ls.getClass().getDeclaredMethod("add",Object.class);


            method.invoke(ls,"test");
            method.invoke(ls,42.9f);
        } catch (NoSuchMethodException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (SecurityException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (IllegalArgumentException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        for ( Object o: ls){
            System.out.println(o);
        }
    }

}