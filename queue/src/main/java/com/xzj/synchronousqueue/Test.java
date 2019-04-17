package com.xzj.synchronousqueue;

/**
 * @author xuzhijun.online  
 * @date 2019年4月17日
 */
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.SynchronousQueue;

public class Test {
	public static void main(String[] args) {
		final BlockingQueue<String> synchronousQueue = new SynchronousQueue<String>(true);

		SynchronousQueueProducer queueProducer = new SynchronousQueueProducer(synchronousQueue);
		new Thread(queueProducer).start();

		SynchronousQueueConsumer queueConsumer1 = new SynchronousQueueConsumer(synchronousQueue);
		new Thread(queueConsumer1).start();

		SynchronousQueueConsumer queueConsumer2 = new SynchronousQueueConsumer(synchronousQueue);
		new Thread(queueConsumer2).start();
		
		SynchronousQueueConsumer queueConsumer3 = new SynchronousQueueConsumer(synchronousQueue);
		new Thread(queueConsumer3).start();

	}
}