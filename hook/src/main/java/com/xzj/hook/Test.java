package com.xzj.hook;

import java.util.concurrent.TimeUnit;

/**
 * 在程序即将退出的时候，也就是 JVM 程序即将退出的时候，Hook 线程就会被启动执行。
* @author 作者: xuzhijun.com
* @createDate 创建时间：2019年4月16日 下午8:49:28
*/
public class Test {

	public static void main(String[] args) {
	
		//为应用程序注入Hook(钩子)线程
		Runtime.getRuntime().addShutdownHook(new Thread(() -> {
			try {
				System.out.println("The hook thread 1 is running.");
				TimeUnit.SECONDS.sleep(2);
			} catch (Exception e) {
				e.printStackTrace();
			}
			System.out.println("The hook thread 1 will exit.");
		}));
		//再注册一个Hook(钩子)线程
		Runtime.getRuntime().addShutdownHook(new Thread(() -> {
			try {
				System.out.println("The hook thread 2 is running.");
				TimeUnit.SECONDS.sleep(2);
			} catch (Exception e) {
				e.printStackTrace();
			}
			System.out.println("The hook thread 2 will exit.");
		}));
		
		System.out.println("The main thread will exit.");
	}

}
