package com.xzj.demo;

public class Coder extends Person{
	
	static {
		System.out.println("����-��̬�����0");
	}
	
	private static String language = "";
	
	static {
		System.out.println("����-��̬�����1�� "+language);
		language = "java";
		System.out.println("����-��̬�����1�� "+language);
	}
	//������ҳ
	private static String home = "";
	
	static {
		System.out.println("����-��̬�����2�� "+home);
		home = "xxx.com";
		System.out.println("����-��̬�����2�� "+home);
	}
	
	public Coder() {
		System.out.println("����-���췽��");
	}

}
