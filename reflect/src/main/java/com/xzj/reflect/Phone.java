package com.xzj.reflect;

/**
 * @author 作者: xuzhijun.com
 * @createDate 创建时间：2019年4月25日 上午10:10:35
 */
public class Phone {

	int price;
	String brand;

	private Phone() {

	}

	private Phone(int price, String brand) {
		this.price = price;
		this.brand = brand;
	}

	@Override
	public String toString() {
		return price + "\t" + brand;
	}

}