package com.xzj.demo;

import java.util.HashMap;
import java.util.Map;

/**
 * 1���������ܼ̳��κ���
 * 2����������ʵ�ֽӿ�
 *
 */
public abstract class Person extends Mammal implements Interface2,Interface3{
	
	final String gender = "��";
	
	Map tmp = new HashMap<>();
	
	final Map interst = tmp;
	
	void eat() {System.out.println("���������ȫ�Ƿǳ��󷽷�");};
	
	abstract void see();
	//ʵ�ֵĽӿ�����ͬ��Ĭ�Ϸ���ʱ���̳�����Ҫ��д; 
	@Override
	public void method_defalut_1() {
		// TODO Auto-generated method stub
		Interface2.super.method_defalut_1();
	}

	public Person() {
		// TODO Auto-generated constructor stub
		System.out.println("���������й��췽����ȴ���ܱ�����ʵ����");
	}

}
