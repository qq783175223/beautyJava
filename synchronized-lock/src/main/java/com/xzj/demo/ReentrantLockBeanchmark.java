package com.xzj.demo;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author 作者: xuzhijun.com
 * @createDate 创建时间：2019年4月26日 上午11:43:00
 */
public class ReentrantLockBeanchmark implements Counter {
	
	private volatile long count = 0;
	private Lock lock;

	public ReentrantLockBeanchmark(boolean isFair) {
		// 使用非公平锁，true就是公平锁
		lock = new ReentrantLock(isFair);
	}

	public long getValue() {
		// TODO Auto-generated method stub
		return count;
	}

	public void increment() {
		lock.lock();
		try {
			count++;
		} finally {
			lock.unlock();
		}
	}
}