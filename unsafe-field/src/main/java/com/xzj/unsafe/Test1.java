package com.xzj.unsafe;


import java.lang.reflect.Field;
import sun.misc.Unsafe;

/**
 *
 * @author xuzhijun.online
 * @author 2019年4月23日
 *
 */


public class Test1 {
    public static void main(String[] args) throws NoSuchFieldException,
            SecurityException, IllegalArgumentException, IllegalAccessException {
        // 通过反射得到theUnsafe对应的Field对象
        Field field = Unsafe.class.getDeclaredField("theUnsafe");
        // 设置该Field为可访问
        field.setAccessible(true);
        // 通过Field得到该Field对应的具体对象，传入null是因为该Field为static的
        Unsafe unsafe = (Unsafe) field.get(null);
        System.out.println(unsafe);

    }
}