package com.xzj.demo;

public class Coder extends Person {

	@Override
	void see() {
		System.out.println("子类实现抽象父类的see方法");

	}


	public Coder() {
		// TODO Auto-generated constructor stub
		System.out.println(this.gender);
		//final 关键字修饰下其引用不可改变(this.interst = new HashMap<>();)但是其引用的值能被改变
		this.tmp.put("电视剧", "权利的游戏");
		System.out.println(this.interst.get("电视剧"));
		this.tmp.put("电视剧", "冰与火之歌");
		System.out.println(this.interst.get("电视剧"));
	}

}
