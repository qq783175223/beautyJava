package com.xzj.field;

import java.lang.reflect.Field;
import java.util.Date;

/**
 *
 * @author xuzhijun.online
 * @author 2019年4月23日
 *
 */

public class ReflectFieldTest {

	public static void main(String[] args) throws Exception {
		
		Student stu = new Student();
//		stu.setId(1L);
//		stu.setName("Josean");
//		stu.setNo("201403185203344");
//		stu.setCreatedate(new Date());
		
		Field property1 = stu.getClass().getDeclaredField("name");
		System.out.println(property1);// private java.lang.String com.cx.test.Student.name
		Field property3 = stu.getClass().getField("nickname");
		System.out.println(property3);// public java.lang.String com.cx.test.Student.nickname
		// 错误方法 getField系列方法只能获取公共字段
//		Field property2 = stu.getClass().getField("name");
//		System.out.println(property2);
		// 会抛java.lang.NoSuchFieldException
		
		System.out.println();
		System.out.println("********************************");
		System.out.println();
		
		System.out.println(property3.get(stu));
        //设置用set类方法
        property3.set(stu, "xumeili");
        System.out.println(stu.getNickname());
        
        //私有变量必须先设置Accessible为true
        property1.setAccessible(true);
        System.out.println(property1.get(stu));
        //设置用set类方法(其本质是调用unsafe.putxxx()方法)
        property1.set(stu, "xuzhijun");
        System.out.println(stu.getName());
        
	}
}
