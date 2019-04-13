package com.xzj.thread;

/**
 * @author xuzhijun.online
 * @date 2019年4月13日
 */
public class YieldTest extends Thread {

	public YieldTest(String name) {
		super(name);
	}

	@Override
	public void run() {
		for (int i = 1; i <= 500; i++) {
			System.out.println("" + this.getName() + "-----" + i);
			// 当i为400时，该线程就会把CPU时间让掉，让其他或者自己的线程执行（也就是谁先抢到谁执行）
			if (i == 400) {
				YieldTest.yield();
			}
		}
	}

	public static void main(String[] args) {
		YieldTest yt1 = new YieldTest("张三");
		YieldTest yt2 = new YieldTest("李四");
		//设置高优先级只能保证优先的概率增大, 并不能保证一定优先
//		yt1.setPriority(6);
		yt1.start();
		yt2.start();
	}
}