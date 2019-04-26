package com.xzj.demo;

import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author 作者: xuzhijun.com
 * @createDate 创建时间：2019年4月26日 下午3:11:31
 */

public class CyclicBarrierTest {

	public static void main(String[] args) {
		ExecutorService service = Executors.newCachedThreadPool();
		// final CyclicBarrier cb = new CyclicBarrier(3);//创建CyclicBarrier对象并设置3个公共屏障点
		final CyclicBarrier cb = new CyclicBarrier(3, new Runnable() {
			@Override
			public void run() {
				//使用最后一个到达集合点的线程执行这个task
				System.out.println(Thread.currentThread().getName()+": ********我最先执行***********");
			}
		});
		for (int i = 0; i < 3; i++) {
			Runnable runnable = new Runnable() {
				public void run() {
					try {
						Thread.sleep((long) (Math.random() * 10000));
						System.out.println("线程" + Thread.currentThread().getName() + "即将到达集合地点1，当前已有"
								+ cb.getNumberWaiting() + "个已经到达，正在等候");
						cb.await();// 到此如果没有达到公共屏障点，则该线程处于等待状态，如果达到公共屏障点则所有处于等待的线程都继续往下运行

						Thread.sleep((long) (Math.random() * 10000));
						System.out.println("线程" + Thread.currentThread().getName() + "即将到达集合地点2，当前已有"
								+ cb.getNumberWaiting() + "个已经到达，正在等候");
						cb.await(); // 这里CyclicBarrier对象又可以重用
						Thread.sleep((long) (Math.random() * 10000));
						System.out.println("线程" + Thread.currentThread().getName() + "即将到达集合地点3，当前已有"
								+ cb.getNumberWaiting() + "个已经到达，正在等候");
						cb.await();
					} catch (Exception e) {
						e.printStackTrace();
					}
				}
			};
			service.execute(runnable);
		}
		service.shutdown();
	}
}