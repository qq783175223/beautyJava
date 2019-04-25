package com.xzj.demo1;

import java.io.Serializable;

/**
 * @author 作者: xuzhijun.com
 * @createDate 创建时间：2019年4月25日 下午2:11:27
 */
public class Person implements Serializable {

	private String name = null;

	private Integer age = null;

	private Gender gender = null;

	public Person() {
		System.out.println("none-arg constructor");
	}

	public Person(String name, Integer age, Gender gender) {
		System.out.println("arg constructor");
		this.name = name;
		this.age = age;
		this.gender = gender;
	}

	@Override
	public String toString() {
		return "[" + name + ", " + age + ", " + gender + "]";
	}
}