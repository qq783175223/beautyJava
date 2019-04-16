package com.xzj.demo;

import java.util.Observable;

/**
 *   被观察者 线程 类
 * @author 作者: xuzhijun.com
 * @createDate 创建时间：2019年4月16日 下午8:17:16
 */
public class MyTask extends Observable implements Runnable {

	public void run() {
		int c = 0;
		// 模拟线程运行一段时间之后退出
		while (true) {
			System.out.println("Runing- " + c);
			try {
				Thread.sleep(2000);
			} catch (InterruptedException e) {
				e.printStackTrace();
				// 只有在setChange()被调用后，notifyObservers()才会去调用update()，否则什么都不干。
				super.setChanged();
				super.notifyObservers();
				break;
			}
			c++;
			// 模拟抛出异常
			try {
				if (c == 4) {
					String str = null;
					// 此处将会抛出空指针异常
					str.length();
				}
			} catch (Exception e) {
				e.printStackTrace();
				// 在抛出异常时调用，通知观察者，让其重启线程
				super.setChanged();
				super.notifyObservers();
				// 异常抛出之后，一定要跳出循环，保证将线程送进地狱
				break;
			}
		}
	}

}
