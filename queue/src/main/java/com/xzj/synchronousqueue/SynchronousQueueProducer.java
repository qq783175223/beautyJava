package com.xzj.synchronousqueue;

/**
 * @author xuzhijun.online  
 * @date 2019年4月17日
 */
import java.util.Random;
import java.util.UUID;
import java.util.concurrent.BlockingQueue;

public class SynchronousQueueProducer implements Runnable {

	protected BlockingQueue<String> blockingQueue;
	final Random random = new Random();

	public SynchronousQueueProducer(BlockingQueue<String> queue) {
		this.blockingQueue = queue;
	}

	@Override
	public void run() {
		while (true) {
			try {
				String data = UUID.randomUUID().toString();
				System.out.println("Put: " + data);
				blockingQueue.put(data);
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

}