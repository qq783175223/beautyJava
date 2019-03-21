package com.xzj.fp.reflect;

import java.lang.reflect.Method;

/**
* @author 作者: xuzhijun.com
* @createDate 创建时间：2019年3月21日 下午2:14:46
*/
public class App {

    public static void main(String[] args) throws Exception{
    	
        Class[] parameterTypes = new Class[2];
        parameterTypes[0] = Integer.class;
        parameterTypes[1] = Integer.class;
        
        Method add = App.class.getMethod("add", parameterTypes);
        
        Method multiply = App.class.getMethod("multiply", parameterTypes);

        App demo = new App();
        
        demo.arithmetic(demo, add, 100, 200);
        
        demo.arithmetic(demo, multiply, 100, 200);
    }
    
    public void add(Integer a, Integer b) {
        System.out.println(a+b);
    }
    
    public void multiply(Integer a, Integer b) {
    	System.out.println(a*b);
    }

    public void arithmetic(Object object, Method method, Integer a, Integer b) throws Exception {
        Object[] parameters = new Object[2];
        parameters[0] = a;
        parameters[1] = b;
        method.invoke(object, parameters);
    }

}
