package com.xzj.demo;

/**
* @author 作者: xuzhijun.com
* @createDate 创建时间：2019年4月26日 上午11:42:24
*/

public class SynchronizeBenchmark implements Counter { 
    private long count = 0; 
    public long getValue() { 
        return count; 
    } 
    public synchronized void increment() { 
        count++; 
    } 
}