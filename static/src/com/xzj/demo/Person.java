package com.xzj.demo;

public class Person {
	
	static {
		System.out.println("父类-静态代码块0");
	}
	
	public static String gender = "";
	
	static {
		System.out.println("父类-静态代码块1："+gender);
		gender= "男" ;
		System.out.println("父类-静态代码块1："+gender);
	}
	
	public static int age = 0;
	
	static {
		System.out.println("父类-静态代码块2："+age);
		age = 18 ;
		System.out.println("父类-静态代码块2："+age);
	}
	
	public Person() {
		System.out.println("父类-构造方法");
	}

}
