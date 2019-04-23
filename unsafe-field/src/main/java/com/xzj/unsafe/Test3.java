package com.xzj.unsafe;

import java.lang.reflect.Field;

import sun.misc.Unsafe;

/**
 *
 * @author xuzhijun.online
 * @author 2019年4月23日
 *
 */



class User2 {
    private String name = "test"; 
    private long id = 1;
    private int age = 2;
    private double height = 1.72;
    

    @Override
    public String toString() {
        return name + "," + id + "," + age + "," + height;
    }
}


public class Test3 {
    public static void main(String[] args) throws NoSuchFieldException,
            SecurityException, IllegalArgumentException, IllegalAccessException, InstantiationException {
        // 通过反射得到theUnsafe对应的Field对象
        Field field = Unsafe.class.getDeclaredField("theUnsafe");
        // 设置该Field为可访问
        field.setAccessible(true);
        // 通过Field得到该Field对应的具体对象，传入null是因为该Field为static的
        Unsafe unsafe = (Unsafe) field.get(null);

        User2 user = new User2();
        System.out.println(user); //打印test,1,2,1.72
        
        Class userClass = user.getClass();
        Field name = userClass.getDeclaredField("name");
        Field id = userClass.getDeclaredField("id");
        Field age = userClass.getDeclaredField("age");
        Field height = userClass.getDeclaredField("height");
        //直接往内存地址写数据
        unsafe.putObject(user, unsafe.objectFieldOffset(name), "midified-name");
        unsafe.putLong(user, unsafe.objectFieldOffset(id),100l);
        unsafe.putInt(user, unsafe.objectFieldOffset(age), 101);
        unsafe.putDouble(user, unsafe.objectFieldOffset(height), 100.1);
        
        System.out.println(user);//打印midified-name,100,101,100.1
        
        //通过Field对象直接修改(其本质还是调用上述unsafe.putxxx()方法)
        height.setAccessible(true);
        height.set(user, 200.2);
        
        System.out.println(user);//打印midified-name,100,101,100.1

    }
}