package com.xzj;

import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

import com.google.common.util.concurrent.ThreadFactoryBuilder;


/**
 * 1 先启用核心线程
 * 2 核心线程不够，放入队列
 * 3 队列放满，启用非核心线程
 * @author xuzhijun.online
 * @date 2019年4月11日
 */
public class Demo3 {
	
	static ThreadFactory namedThreadFactory = new ThreadFactoryBuilder().setNameFormat("demo-pool-%d").build();
	static ThreadPoolExecutor executor = new ThreadPoolExecutor(1, 4, 0L, TimeUnit.MILLISECONDS, new LinkedBlockingQueue<Runnable>(2), namedThreadFactory, new ThreadPoolExecutor.AbortPolicy());

	public static void main(String[] args) throws InterruptedException {
		
		Runnable myRunnable = new Runnable() {
		    @Override
		    public void run() {
		        try {
		            Thread.sleep(2000);
		            System.out.println(Thread.currentThread().getName() + " run");
		        } catch (InterruptedException e) {
		            e.printStackTrace();
		        }

		    }
		};
		
		
		/**
		 * 1
		 * 1
		 * 2
		 * 
		 * 1
		 * 4
		 * 2
		 * 
		 * 1
		 * 1
		 * 0
		 * 
		 * 1
		 * 1
		 * 0
		 */
		executor.execute(myRunnable);
		executor.execute(myRunnable);
		executor.execute(myRunnable);
		System.out.println("---先开三个---");
		System.out.println("核心线程数" + executor.getCorePoolSize());
		System.out.println("线程池数" + executor.getPoolSize());
		System.out.println("队列任务数" + executor.getQueue().size());
		executor.execute(myRunnable);
		executor.execute(myRunnable);
		executor.execute(myRunnable);
		System.out.println("---再开三个---");
		System.out.println("核心线程数" + executor.getCorePoolSize());
		System.out.println("线程池数" + executor.getPoolSize());
		System.out.println("队列任务数" + executor.getQueue().size());
		Thread.sleep(8000);
		System.out.println("----8秒之后----");
		System.out.println("核心线程数" + executor.getCorePoolSize());
		System.out.println("线程池数" + executor.getPoolSize());
		System.out.println("队列任务数" + executor.getQueue().size());
		Thread.sleep(20000);
		System.out.println("----20秒之后----");
		System.out.println("核心线程数" + executor.getCorePoolSize());
		System.out.println("线程池数" + executor.getPoolSize());
		System.out.println("队列任务数" + executor.getQueue().size());

	}

}
