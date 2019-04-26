* CountDownLatch和CyclicBarrier都能够实现线程之间的等待，只不过它们侧重点不同：
CountDownLatch一般用于某个线程A等待若干个其他线程执行完任务之后，它才执行；
而CyclicBarrier一般用于一组线程共同等待至某个状态，然后这一组线程再同时执行；
另外，CountDownLatch是不能够重用的，而CyclicBarrier是可以重用的。

* Semaphore其实和锁有点类似，它一般用于控制对某组资源的访问权限。

[CyclicBarrier的用法](http://www.cnblogs.com/liuling/p/2013-8-21-01.html)

[Java并发编程：CountDownLatch、CyclicBarrier和Semaphore](https://www.cnblogs.com/dolphin0520/p/3920397.html)

[Semaphore in Java](https://www.geeksforgeeks.org/semaphore-in-java/)

[CyclicBarrier in Java](https://www.geeksforgeeks.org/java-util-concurrent-cyclicbarrier-java/)

[CountDownLatch in Java](https://www.geeksforgeeks.org/countdownlatch-in-java/)
