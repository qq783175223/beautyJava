package com.xzj.demo1;

/**
 * @author 作者: xuzhijun.com
 * @createDate 创建时间：2019年4月15日 上午9:01:33
 */
public abstract class Abstract {
	
	public final static String COM = "XUZHIJUN";

	public static void main(String[] args) {
		System.out.println("Main method from Abstract.");
	}
	
	public static void staticMethod() {
		System.out.println("Static method from Abstract.");
	}
	
	public abstract void showMessage();

	static class InnerClass extends Abstract {
		@Override
		public void showMessage() {
			System.out.println("Inner Class from Abstract");
		}
	}
}