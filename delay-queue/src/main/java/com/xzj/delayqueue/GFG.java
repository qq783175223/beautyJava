package com.xzj.delayqueue;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.DelayQueue;
import java.util.concurrent.TimeUnit;

/**
 * Driver Class 
 * @author xuzhijun.online
 * @date 2019年4月13日
 */
public class GFG {
	public static void main(String[] args) throws InterruptedException {

		// create object of DelayQueue
		// using DelayQueue() constructor
		BlockingQueue<DelayObject> DQ = new DelayQueue<DelayObject>();

		// Add numbers to end of DelayQueue
		// using add() method
		
		DelayObject A = new DelayObject("A", 1);
		DelayObject B = new DelayObject("B", 2);
		DelayObject C = new DelayObject("C", 3);
		DelayObject D = new DelayObject("D", 4);
		
		DQ.add(A);
		DQ.add(B);
		DQ.add(C);
		DQ.add(D);

		// print queue
		System.out.println("DelayQueue: " + DQ);

		// print the head using peek() method
		System.out.println("Head of DelayQueue: " + DQ.peek());

		// print the size using size() method
		System.out.println("Size of DelayQueue: " + DQ.size());
		
		Thread.sleep(1);
		
		System.err.println(A.getDelay(TimeUnit.MILLISECONDS));
		System.err.println(B.getDelay(TimeUnit.MILLISECONDS));
		System.err.println(C.getDelay(TimeUnit.MILLISECONDS));
		System.err.println(D.getDelay(TimeUnit.MILLISECONDS));
		
		// remove the head using poll() method
		System.out.println("Head of DelayQueue: " + DQ.poll());
		// print the size using size() method
		System.out.println("Size of DelayQueue: " + DQ.size());
		
		System.err.println(A.getDelay(TimeUnit.MILLISECONDS));
		System.err.println(B.getDelay(TimeUnit.MILLISECONDS));
		System.err.println(C.getDelay(TimeUnit.MILLISECONDS));
		System.err.println(D.getDelay(TimeUnit.MILLISECONDS));
		
		// remove the head using poll() method
		System.out.println("Head of DelayQueue: " + DQ.poll());
		// print the size using size() method
		System.out.println("Size of DelayQueue: " + DQ.size());
		
		System.err.println(A.getDelay(TimeUnit.MILLISECONDS));
		System.err.println(B.getDelay(TimeUnit.MILLISECONDS));
		System.err.println(C.getDelay(TimeUnit.MILLISECONDS));
		System.err.println(D.getDelay(TimeUnit.MILLISECONDS));
		
		// remove the head using poll() method
		System.out.println("Head of DelayQueue: " + DQ.poll());
		// print the size using size() method
		System.out.println("Size of DelayQueue: " + DQ.size());

		// clear the DelayQueue using clear() method
		DQ.clear();
		System.out.println("Size of DelayQueue" + " after clear: " + DQ.size());
	}
}
