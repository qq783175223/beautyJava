package com.xzj.unsafe;

import java.lang.reflect.Field;

import sun.misc.Unsafe;

/**
 *
 * @author xuzhijun.online
 * @author 2019年4月23日
 *
 */


class User {
    private String name = "xuzhijun";
    private int age = 0;

    public User() {
        this.name = "test";
        this.age = 22;
    }
    
    @Override
    public String toString() {
        return name + ": " + age;
    }
}


public class Test2 {
    public static void main(String[] args) throws NoSuchFieldException,
            SecurityException, IllegalArgumentException, IllegalAccessException, InstantiationException {
        // 通过反射得到theUnsafe对应的Field对象
        Field field = Unsafe.class.getDeclaredField("theUnsafe");
        // 设置该Field为可访问
        field.setAccessible(true);
        // 通过Field得到该Field对应的具体对象，传入null是因为该Field为static的
        Unsafe unsafe = (Unsafe) field.get(null);

        User user = (User) unsafe.allocateInstance(User.class);
        System.out.println(user); //dont invoke constructor, print null: 0
        
        User userFromNormal = new User();
        System.out.println(userFromNormal); //print test: 22

    }
}
