package com.xzj.erasure;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

/**
 * Create by xuzhijun.online on 2019/11/14.
 *
 * 泛型类型擦除
 */

public class Main {
    public static void main(String[] args) {
        /**
         * output: erasure class is:com.xzj.erasure.Erasure1
         */
        Erasure1<String> erasure1 = new Erasure1<String>("hello");
        Class eclz1 = erasure1.getClass();
        System.out.println("erasure class is:" + eclz1.getName());

        /**
         * output: Field name object type:java.lang.Object
         */
        Field[] fs1 = eclz1.getDeclaredFields();
        for (Field f : fs1) {
            System.out.println("Field name " + f.getName() + " type:" + f.getType().getName());
        }

        /**
         * output: erasure class is:com.xzj.erasure.Erasure2
         */
        Erasure2<String> erasure2 = new Erasure2<String>("hello");
        Class eclz2 = erasure2.getClass();
        System.out.println("erasure class is:" + eclz2.getName());

        /**
         * output: Field name object type:java.lang.String
         */
        Field[] fs2 = eclz2.getDeclaredFields();
        for (Field f : fs2) {
            System.out.println("Field name " + f.getName() + " type:" + f.getType().getName());
        }

        /**
         * 我们现在可以下结论了，在泛型类被类型擦除的时候，
         * 之前泛型类中的类型参数部分如果没有指定上限，
         * 如 <T>则会被转译成普通的 Object 类型，如果指定了上限如 <T extends String>则类型参数就被替换成类型上限。
         */

        /**
         * output:  method:public void com.xzj.erasure.Erasure1.add(java.lang.Object)
         */
        Method[] methods = eclz1.getDeclaredMethods();
        for (Method m : methods) {
            System.out.println("method:" + m.toString());
        }

        /**
         * 也就是说，如果你要在反射中找到 add 对应的 Method，
         * 你应该调用 getDeclaredMethod("add",Object.class)否则程序会报错，
         * 提示没有这么一个方法，原因就是类型擦除的时候，T 被替换成 Object 类型了。
         */
    }
}
