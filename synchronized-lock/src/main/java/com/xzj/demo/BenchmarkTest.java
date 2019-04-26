package com.xzj.demo;

import java.util.concurrent.CyclicBarrier;

/**
 * 非公平的ReentrantLock和synchronized性能不分伯仲
 * 
 * 公平的ReentrantLock在高并发的情况下性能较差
 * 
 * @author 作者: xuzhijun.com
 * @createDate 创建时间：2019年4月26日 上午11:43:59
 */

public class BenchmarkTest {
	private Counter counter;
	private CyclicBarrier barrier;
	private int threadNum;

	public BenchmarkTest(Counter counter, int threadNum) {
		this.counter = counter;
		barrier = new CyclicBarrier(threadNum + 1); // 关卡计数=线程数+1
		this.threadNum = threadNum;
	}

	public static void main(String args[]) {
//		new BenchmarkTest(new ReentrantLockBeanchmark(false), 20000).test();
		new BenchmarkTest(new SynchronizeBenchmark(), 20000).test();
//		new BenchmarkTest(new ReentrantLockBeanchmark(true), 10000).test();
	}

	public void test() {
		try {
			for (int i = 0; i < threadNum; i++) {
				new TestThread(counter).start();
			}
			long start = System.currentTimeMillis();
//			System.out.println(Thread.currentThread().getName()+": 到达集合地点1"+"——等待所有任务线程创建...");
			barrier.await(); // 等待所有任务线程创建
//			System.out.println(Thread.currentThread().getName()+": 到达集合地点2"+"——等待所有任务计算完成...");
			barrier.await(); // 等待所有任务计算完成
			long end = System.currentTimeMillis();
			System.out.println("count value:" + counter.getValue());
			System.out.println("花费时间:" + (end - start) + "毫秒");
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	class TestThread extends Thread {
		private Counter counter;

		public TestThread(final Counter counter) {
			this.counter = counter;
		}

		public void run() {
			try {
//				System.out.println(Thread.currentThread().getName()+": 到达集合地点1"+"——等待其他线程就位...");
				barrier.await();
				for (int i = 0; i < 100; i++) {
					counter.increment();
				}
//				System.out.println(Thread.currentThread().getName()+": 到达集合地点2"+"——等待其他线程就位...");
				barrier.await();
			} catch (Exception e) {
				throw new RuntimeException(e);
			}
		}
	}
}
