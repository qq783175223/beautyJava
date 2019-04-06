package com.xzj.demo;

import java.util.HashMap;
import java.util.Map;

/**
 * 1、抽象类能继承任何类
 * 2、抽象类能实现接口
 *
 */
public abstract class Person extends Mammal implements Interface2,Interface3{
	
	final String gender = "男";
	
	Map tmp = new HashMap<>();
	
	final Map interst = tmp;
	
	void eat() {System.out.println("抽象类可以全是非抽象方法");};
	
	abstract void see();
	//实现的接口有相同的默认方法时，继承类需要重写; 
	@Override
	public void method_defalut_1() {
		// TODO Auto-generated method stub
		Interface2.super.method_defalut_1();
	}

	public Person() {
		// TODO Auto-generated constructor stub
		System.out.println("抽象类能有构造方法，却不能被单独实例化");
	}

}
