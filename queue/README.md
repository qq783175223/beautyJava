

* SynchronousQueue类似接力赛，其没有队列容量，生产者阻塞到有消费者，消费者阻塞到有生产者 。多个消费者时，默认是非公平的，可以设置成公平的。[博文参考链接](https://javapapers.com/java/java-synchronousqueue/)

* LinkedBlockingQueue队列满了后，生产者put阻塞到队列有空间为止。如果有多个消费者，消费者线程公平的take队列
