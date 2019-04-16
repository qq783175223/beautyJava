package com.xzj.hook;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

/**
 * @author 作者: xuzhijun.com
 * @createDate 创建时间：2019年4月16日 下午8:59:02
 */
public class PreventDuplicated {
	/** .lock 文件存放路径 */
	private static final String LOCK_FILE_PATH = "C:\\Users\\GoneBoy\\Desktop\\api\\";

	/** .lock 文件名称 */
	private static final String LOCK_FILE_NAME = ".lock";

	public static void main(String[] args) {
		// 校验 .lock 文件是否已经存在
		checkLockFile();
		// 注入 Hook 线程
		addShutdownHook();
		// 模拟程序一直运行
		for (;;) {
			try {
				TimeUnit.SECONDS.sleep(1);
				System.out.println("The program is running ...");
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

	/**
	 * 注入 Hook 线程
	 */
	private static void addShutdownHook() {
		Runtime.getRuntime().addShutdownHook(new Thread(() -> {
			// 接受到了退出信号
			System.out.println("The program received kill signal.");
			// 删除 .lock 文件
			deleteLockFile();
		}));
	}

	/**
	 * 校验 .lock 文件是否已经存在
	 */
	private static void checkLockFile() {
		if (isLockFileExisted()) {
			// .lock 文件已存在, 抛出异常, 退出程序
			throw new RuntimeException("The program already running.");
		}
		// 不存在，则创建 .lock 文件
		createLockFile();
	}

	/**
	 * 创建 .lock 文件
	 */
	private static void createLockFile() {
		File file = new File(LOCK_FILE_PATH + LOCK_FILE_NAME);
		try {
			file.createNewFile();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	/**
	 * .lock 文件 是否存在
	 * 
	 * @return
	 */
	private static boolean isLockFileExisted() {
		File file = new File(LOCK_FILE_PATH + LOCK_FILE_NAME);
		return file.exists();
	}

	/**
	 * 删除 .lock 文件
	 */
	private static void deleteLockFile() {
		File file = new File(LOCK_FILE_PATH + LOCK_FILE_NAME);
		file.delete();
	}
}