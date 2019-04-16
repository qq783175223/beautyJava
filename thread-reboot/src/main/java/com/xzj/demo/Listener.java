package com.xzj.demo;

import java.util.Observable;
import java.util.Observer;

/**
 * 观察者 线程 类
* @author 作者: xuzhijun.com
* @createDate 创建时间：2019年4月16日 下午8:26:59
*/
public class Listener implements Observer{

	public void update(Observable o, Object arg) {
		
		System.out.println("MyThread死机");
		
		MyTask myTask= new MyTask();
		
		myTask.addObserver(this);
		
        new Thread(myTask).start();

        System.out.println("MyThread重启");
		
	}
	
}
