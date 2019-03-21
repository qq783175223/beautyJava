package com.xzj.fp.callable;

/**
* @author 作者: xuzhijun.com
* @createDate 创建时间：2019年3月21日 下午2:15:12
*/
public class App{
	
	public static int add(int a ,int b) {
        // do something
		return a+b; 
	}
	public static int multiply(int a ,int b) {
		// do something
		return a*b; 
	}
	
	//四则运算
	public static void arithmetic(int a, int b, MyCallable<Integer,Integer,Integer> func) throws Exception {
		
		int res = func.call(a, b);
		
		System.out.println(res);
	}

	public static void main(String[] args) throws Exception {
		
		MyCallable<Integer, Integer, Integer> add = new MyCallable<Integer, Integer, Integer>() {
			@Override
			public Integer call(Integer a, Integer b) throws Exception {
				// TODO Auto-generated method stub
				return add(a, b);
			}
		};
		
		MyCallable<Integer, Integer, Integer> multiply = new MyCallable<Integer, Integer, Integer>() {
			@Override
			public Integer call(Integer a, Integer b) throws Exception {
				// TODO Auto-generated method stub
				return multiply(a, b);
			}
		};
		
		arithmetic(100, 200, add);
		
		arithmetic(100, 200, multiply);
	}
	
}
