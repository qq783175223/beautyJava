package com.xzj.demo3;

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

	public static void main(String[] args) throws Exception {
		File file = new File("person.out");

		ObjectOutputStream oout = new ObjectOutputStream(new FileOutputStream(file));
		Person person = new Person("John", 120, 18, Gender.MALE);
		oout.writeObject(person);
		oout.close();

		ObjectInputStream oin = new ObjectInputStream(new FileInputStream(file));
		Object newPerson = oin.readObject(); // 没有强制转换到Person类型
		oin.close();
		System.out.println(newPerson);
	}
}
