package com.xzj.demo4;

import java.io.ObjectStreamException;
import java.io.Serializable;

/**
 * @author 作者: xuzhijun.com
 * @createDate 创建时间：2019年4月25日 下午2:11:27
 */
public class Person implements Serializable  {

	private static class InstanceHolder {
		private static final Person instatnce = new Person("John", 31, Gender.MALE);
	}

	public static Person getInstance() {
		return InstanceHolder.instatnce;
	}

	private String name = null;

	private Integer age = null;

	private Gender gender = null;

	private Person() {
		System.out.println("none-arg constructor");
	}

	private Person(String name, Integer age, Gender gender) {
		System.out.println("arg constructor");
		this.name = name;
		this.age = age;
		this.gender = gender;
	}

	@Override
	public String toString() {
		return "[" + name + ", " + age + ", " + gender + "]";
	}
	
	/**
	 *  单例保证
	 * @return
	 * @throws ObjectStreamException
	 */
    private Object readResolve() throws ObjectStreamException {  
        return InstanceHolder.instatnce;  
    }  

}