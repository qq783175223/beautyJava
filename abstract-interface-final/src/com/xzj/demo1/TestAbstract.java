package com.xzj.demo1;
/**
* @author 作者: xuzhijun.com
* @createDate 创建时间：2019年4月15日 上午9:06:34
*/
public class TestAbstract extends Abstract{

	
	@Override
	public void showMessage() {
		// TODO Auto-generated method stub
	}
	public static void test() {
		System.out.println(TestAbstract.COM);
		TestAbstract.staticMethod();
		//抽象父类的程序入口方法
		TestAbstract.main(null);
	}


}
