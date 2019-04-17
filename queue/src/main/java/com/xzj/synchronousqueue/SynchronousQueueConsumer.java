package com.xzj.synchronousqueue;

/**
 * @author xuzhijun.online  
 * @date 2019年4月17日
 */
import java.util.concurrent.BlockingQueue;

public class SynchronousQueueConsumer implements Runnable {

	protected BlockingQueue<String> blockingQueue;

	public SynchronousQueueConsumer(BlockingQueue<String> queue) {
		this.blockingQueue = queue;
	}

	@Override
	public void run() {
		while (true) {
			try {
				String data = blockingQueue.take();
				System.out.println(Thread.currentThread().getName() + " take(): " + data);
				Thread.sleep(2000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

}