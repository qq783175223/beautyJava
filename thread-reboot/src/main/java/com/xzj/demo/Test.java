package com.xzj.demo;
/**
* @author 作者: xuzhijun.com
* @createDate 创建时间：2019年4月16日 下午8:29:57
*/
public class Test {

	public static void main(String[] args) {
		
		MyTask myTask  = new MyTask();


        Listener listen = new Listener();

        myTask .addObserver(listen);

        new Thread(myTask).start();
	}

}
