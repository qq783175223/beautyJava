package com.xzj.demo;

public class Person {
	
	static {
		System.out.println("����-��̬�����0");
	}
	
	public static String gender = "";
	
	static {
		System.out.println("����-��̬�����1��"+gender);
		gender= "��" ;
		System.out.println("����-��̬�����1��"+gender);
	}
	
	public static int age = 0;
	
	static {
		System.out.println("����-��̬�����2��"+age);
		age = 18 ;
		System.out.println("����-��̬�����2��"+age);
	}
	
	public Person() {
		System.out.println("����-���췽��");
	}

}
