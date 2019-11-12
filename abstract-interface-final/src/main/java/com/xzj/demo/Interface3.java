package com.xzj.demo;

public interface Interface3 {

	static void method_static_1() {System.out.println("接口3-静态方法1");};

	default void method_defalut_1() {System.out.println("接口3-默认方法1");};

}
