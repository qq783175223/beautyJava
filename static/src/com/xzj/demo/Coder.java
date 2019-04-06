package com.xzj.demo;

public class Coder extends Person{
	
	static {
		System.out.println("子类-静态代码块0");
	}
	
	private static String language = "";
	
	static {
		System.out.println("子类-静态代码块1： "+language);
		language = "java";
		System.out.println("子类-静态代码块1： "+language);
	}
	//个人主页
	private static String home = "";
	
	static {
		System.out.println("子类-静态代码块2： "+home);
		home = "xxx.com";
		System.out.println("子类-静态代码块2： "+home);
	}
	
	public Coder() {
		System.out.println("子类-构造方法");
	}

}
