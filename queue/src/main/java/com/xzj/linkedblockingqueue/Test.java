package com.xzj.linkedblockingqueue;

/**
 * @author xuzhijun.online  
 * @date 2019年4月17日
 */
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

/**
 * LinkedBlockingQueue队列满了后，生产者put阻塞到队列有空间为止
 *  如果有多个消费者，消费者线程公平的take队列
 * @author xuzhijun.online 
 * @date 2019年4月17日
 *
 */
public class Test {
	public static void main(String[] args) throws InterruptedException {
		
		final BlockingQueue<String> linkedblockingqueue = new LinkedBlockingQueue<String>(3);

		
		LinkedBlockingQueueProducer queueProducer = new LinkedBlockingQueueProducer(linkedblockingqueue);
		new Thread(queueProducer).start();
		//模拟LinkedBlockingQueue容量不够放的情况
		Thread.sleep(10000);

		LinkedBlockingQueueConsumer queueConsumer1 = new LinkedBlockingQueueConsumer(linkedblockingqueue);
		new Thread(queueConsumer1).start();

		LinkedBlockingQueueConsumer queueConsumer2 = new LinkedBlockingQueueConsumer(linkedblockingqueue);
		new Thread(queueConsumer2).start();
//		
//		LinkedBlockingQueueConsumer queueConsumer3 = new LinkedBlockingQueueConsumer(linkedblockingqueue);
//		new Thread(queueConsumer3).start();

	}
}