package com.xzj.delayqueue;

/**
 * Java Program Demonstrate DelayQueue methods 
 * @author xuzhijun.online  
 * @date 2019年4月13日
 */

import java.util.concurrent.*;

//The DelayObject for DelayQueue 
//It must implement Delayed and 
//its getDelay() and compareTo() method 
class DelayObject implements Delayed {
	private String name;
	private long time;

	// Contructor of DelayObject
	public DelayObject(String name, long delayTime) {
		this.name = name;
		this.time = System.currentTimeMillis() + delayTime;
	}

	// Implementing getDelay() method of Delayed
	@Override
	public long getDelay(TimeUnit unit) {
		long diff = time - System.currentTimeMillis();
		return unit.convert(diff, TimeUnit.MILLISECONDS);
	}

	// Implementing compareTo() method of Delayed
	@Override
	public int compareTo(Delayed obj) {
		if (this.time < ((DelayObject) obj).time) {
			return -1;
		}
		if (this.time > ((DelayObject) obj).time) {
			return 1;
		}
		return 0;
	}

	// Implementing toString() method of Delayed
	@Override
	public String toString() {
		return "\n{" + "name=" + name + ", time=" + time + "}";
	}
}