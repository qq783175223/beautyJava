package com.xzj;

import java.util.ArrayList;
import java.util.List;
import java.util.Vector;
import java.util.concurrent.CopyOnWriteArrayList;

/**
* @author 作者: xuzhijun.com
* @createDate 创建时间：2019年3月29日 上午11:51:15
*/
public class Test {
	
	public static void main(String[] args) {
		
		MyRunnable shareRunnableInstance = new MyRunnable();
		Thread t1 = new Thread(shareRunnableInstance);
		Thread t2 = new Thread(shareRunnableInstance);
		t1.start();
		t2.start();
	}
}

class MyRunnable implements Runnable{
	
	private ThreadLocal<Integer> threadlocal = new ThreadLocal<Integer>();
	//线程不安全，会出现各种诡异的结果
//	private List<Integer> list = new ArrayList<Integer>();
	//无法保证外部遍历时的线程安全，除非使用synchronized同步读代码块，或者使用线程安全的forEach自身遍历
//	private List<Integer> list = new Vector<Integer>();
	private List<Integer> list = new CopyOnWriteArrayList<Integer>();
	private int normal;
	
	public void run() {
		
		int random = (int) (Math.random()*100D);
		threadlocal.set(random);
		list.add(random);
		normal = random;
		
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		System.out.println(Thread.currentThread().getName()+"  threadlocal: "+threadlocal.get());
		for (int i = 0; i < list.size(); i++) {
			System.out.println(Thread.currentThread().getName()+"  list.size: "+list.size()+"  list("+i+"): "+list.get(i));	
		}
		System.out.println(Thread.currentThread().getName()+"  Integer: "+normal);
	}
}