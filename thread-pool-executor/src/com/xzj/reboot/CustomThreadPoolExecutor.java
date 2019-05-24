package com.xzj.reboot;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
* @author 作者: xuzhijun.com
* @createDate 创建时间：2019年4月16日 下午7:32:51
*/
public class CustomThreadPoolExecutor extends ThreadPoolExecutor {
	
    public CustomThreadPoolExecutor(int corePoolSize, int maximumPoolSize, long keepAliveTime, TimeUnit unit, BlockingQueue<Runnable> workQueue, ThreadFactory threadFactory) {
        super(corePoolSize, maximumPoolSize, keepAliveTime, unit, workQueue, threadFactory);
    }
    @Override
    protected void afterExecute(Runnable r, Throwable t) {
        super.afterExecute(r, t);
        //若线程执行某任务失败了，重新提交该任务
        if (t != null) {
            System.out.println("restart task...");
			execute(r);
        }
    }
}
