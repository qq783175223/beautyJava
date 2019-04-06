package com.xzj.demo;


/**
 * 
 *1、接口的成员变量都是static final的
 *2、接口的静态方法只能通过接口本身调用，不能被实现类或者继承接口调用
 *
 */
public interface Interface1{
	
	int int_1 = 1;
	
	static int int_2 = 2;
	
	final int int_3 = 3;
	
	final static int int_4 = 4;
	
	static final int int_5 = 5;
	
	
	static void method_static_1() {System.out.println("接口1-静态方法1");};
	
	static void method_static_2() {System.out.println("接口1-静态方法2");}; 
	
	default void method_defalut_1() {System.out.println("接口1-默认方法1");}; 
	
	default void method_defalut_2() {System.out.println("接口1-默认方法2");}; 

}
