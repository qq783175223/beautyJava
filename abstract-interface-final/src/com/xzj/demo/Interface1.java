package com.xzj.demo;


/**
 * 
 *1���ӿڵĳ�Ա��������static final��
 *2���ӿڵľ�̬����ֻ��ͨ���ӿڱ�����ã����ܱ�ʵ������߼̳нӿڵ���
 *
 */
public interface Interface1{
	
	int int_1 = 1;
	
	static int int_2 = 2;
	
	final int int_3 = 3;
	
	final static int int_4 = 4;
	
	static final int int_5 = 5;
	
	
	static void method_static_1() {System.out.println("�ӿ�1-��̬����1");};
	
	static void method_static_2() {System.out.println("�ӿ�1-��̬����2");}; 
	
	default void method_defalut_1() {System.out.println("�ӿ�1-Ĭ�Ϸ���1");}; 
	
	default void method_defalut_2() {System.out.println("�ӿ�1-Ĭ�Ϸ���2");}; 

}
