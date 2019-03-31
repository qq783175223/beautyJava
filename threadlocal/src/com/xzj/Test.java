package com.xzj;

import java.util.ArrayList;
import java.util.List;
import java.util.Vector;
import java.util.concurrent.CopyOnWriteArrayList;

/**
* @author ����: xuzhijun.com
* @createDate ����ʱ�䣺2019��3��29�� ����11:51:15
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
	//�̲߳���ȫ������ָ��ֹ���Ľ��
//	private List<Integer> list = new ArrayList<Integer>();
	//�޷���֤�ⲿ����ʱ���̰߳�ȫ������ʹ��synchronizedͬ��������飬����ʹ���̰߳�ȫ��forEach�������
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