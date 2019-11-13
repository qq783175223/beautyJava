#include <stdio.h>
#include <sys/types.h>
#include <sys/stat.h>
#include <fcntl.h>
main()
{
	if (mkfifo("/root/java_demo/pipe/xuzhijun_pipe", 0666) < 0)
	{
		printf("\n error when mkfifo");
	}
	int fd;
	if ((fd = open("/root/java_demo/pipe/xuzhijun_pipe", O_RDWR)) < 0)
	{
		perror("Could not open named pipe.");
	}
}