1. 首先通过mkfifo系统函数创建一个管道（管道本质也是一个文件）

    编译：gcc -o pipe pipe.c
    运行：./pipe

2. FifoWriter往管道写数据（会阻塞到有进程来管道读为止）

3. FifoReader从管道读数据（会一直阻塞到有进程往管道内写数据为止）


参考：

https://blog.csdn.net/anhe0901/article/details/80602578#commentBox

https://www.cnblogs.com/52php/p/5840229.html