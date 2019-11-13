package com.xzj.thread;

/**
 * JoinTest.java的源码
 * @author xuzhijun.online
 * @date 2019年4月13日
 */

public class JoinTest {

	public static void main(String[] args) {
		try {
			// 新建“线程t1”
			ThreadA t1 = new ThreadA("t1"); 
			// 启动“线程t1”
			t1.start(); 
			// 将“线程t1”加入到“主线程main”中，并且“主线程main()会等待它的完成”
			t1.join(); 
			System.out.printf("%s finish\n", Thread.currentThread().getName());
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	static class ThreadA extends Thread {

		public ThreadA(String name) {
			super(name);
		}
		@Override
		public void run() {
			System.out.printf("%s start\n", this.getName());

			// 延时操作
			for (int i = 0; i < 1000000; i++) {

			};

			System.out.printf("%s finish\n", this.getName());
		}
	}
}
