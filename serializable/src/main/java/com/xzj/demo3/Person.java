package com.xzj.demo3;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectInputStream;
import java.io.ObjectOutput;
import java.io.ObjectOutputStream;

/**
 * @author 作者: xuzhijun.com
 * @createDate 创建时间：2019年4月25日 下午2:11:27
 */
public class Person implements Externalizable {

	private String name = null;

	private Integer weight = null;

	transient private Integer age = null;

	private Gender gender = null;

	public Person() {
		System.out.println("none-arg constructor");
	}

	public Person(String name, Integer weight, Integer age, Gender gender) {
		System.out.println("arg constructor");
		this.name = name;
		this.weight = weight;
		this.age = age;
		this.gender = gender;
	}

	@Override
	public String toString() {
		return "[" + name + ", " + weight + ", " + age + ", " + gender + "]";
	}

	private void writeObject(ObjectOutputStream out) throws IOException {
		out.defaultWriteObject();
		out.writeInt(age);
	}

	private void readObject(ObjectInputStream in) throws IOException, ClassNotFoundException {
		in.defaultReadObject();
		age = in.readInt();
	}

	/**
	 * 注意write和read的顺序保持一致，否则抛出java.io.OptionalDataException
	 */
	@Override
	public void writeExternal(ObjectOutput out) throws IOException {
		out.writeObject(name);
		out.writeInt(weight);
		out.writeInt(age);
	}

	/**
	 * 注意write和read的顺序保持一致，否则抛出java.io.OptionalDataException
	 */
	@Override
	public void readExternal(ObjectInput in) throws IOException, ClassNotFoundException {
		name = (String) in.readObject();
		age = in.readInt();
		weight = in.readInt();
	}
}