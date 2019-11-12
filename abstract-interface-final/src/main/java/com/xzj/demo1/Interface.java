package com.xzj.demo1;

/**
 * @author 作者: xuzhijun.com
 * @createDate 创建时间：2019年4月15日 上午9:03:30
 */
public interface Interface {
	
	public static final String COM = "XUZHIJUN";

	public void showMessage();
	
	public static void main(String args[]){
		System.out.println("Main method from Interface.");
	}
	
	public static void staticMethod() {
		System.out.println("Static method from Interface.");
	}
	
	static class InnerClass implements Interface{
		@Override
		public void showMessage() {
			System.out.println("Inner Class from Interface");
		}
	}
}
