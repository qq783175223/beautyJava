package com.xzj.reflect;

import java.lang.reflect.Constructor;

/**
 * java反射：调用私有构造函数
 * 
 * @author 作者: xuzhijun.com
 * @createDate 创建时间：2019年4月25日 上午10:11:03
 */
public class Test {

	/* 通过Constructor.newInstance()创建新的类示例 */
	private void newInstanceByConstructor() {
		try {
			/* 可以使用相对路径，同一个包中可以不用带包路径 */
			Class c = Class.forName("com.xzj.reflect.Phone");
			/* 以下调用无参的、私有构造函数 */

			Constructor c0 = c.getDeclaredConstructor();
			c0.setAccessible(true);

			Phone po = (Phone) c0.newInstance();
			System.out.println("不带参的构造函数\t" + po);

			/* 以下调用带参的、私有构造函数 */
			Constructor c1 = c.getDeclaredConstructor(new Class[] { int.class, String.class });
			c1.setAccessible(true);
			Phone p1 = (Phone) c1.newInstance(new Object[] { 1, "诺基亚" });
			System.out.println("带参的构造函数\t" + p1);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) throws Exception {
		Test b = new Test();
		System.out.println("通过Constructor.newInstance()调用私有构造函数:");
		b.newInstanceByConstructor();
	}
}