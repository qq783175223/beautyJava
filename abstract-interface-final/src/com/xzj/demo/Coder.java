package com.xzj.demo;

public class Coder extends Person {

	@Override
	void see() {
		System.out.println("����ʵ�ֳ������see����");

	}
	

	public Coder() {
		// TODO Auto-generated constructor stub
		System.out.println(this.gender);
		//final �ؼ��������������ò��ɸı�(this.interst = new HashMap<>();)���������õ�ֵ�ܱ��ı�
		this.tmp.put("���Ӿ�", "Ȩ������Ϸ");
		System.out.println(this.interst.get("���Ӿ�"));
		this.tmp.put("���Ӿ�", "�����֮��");
		System.out.println(this.interst.get("���Ӿ�"));
	}

}
