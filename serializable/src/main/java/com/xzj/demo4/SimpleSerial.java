package com.xzj.demo4;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

/**
 * @author 作者: xuzhijun.com
 * @createDate 创建时间：2019年4月25日 下午2:12:38
 */
public class SimpleSerial {

	/**
	 *   输出：
	 * arg constructor
	 * [John, 31, MALE]
	 * false/true
	 */
	public static void main(String[] args) throws Exception {
		File file = new File("person.out");
		ObjectOutputStream oout = new ObjectOutputStream(new FileOutputStream(file));
		oout.writeObject(Person.getInstance()); // 保存单例对象
		oout.close();

		ObjectInputStream oin = new ObjectInputStream(new FileInputStream(file));
		Object newPerson = oin.readObject();
		oin.close();
		System.out.println(newPerson);

		System.out.println(Person.getInstance() == newPerson); // 将获取的对象与Person类中的单例对象进行相等性比较
	}
}
