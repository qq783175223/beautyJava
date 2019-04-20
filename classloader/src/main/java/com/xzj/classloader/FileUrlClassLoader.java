package com.xzj.classloader;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URL;
import java.net.URLClassLoader;
import java.net.URLStreamHandlerFactory;

/**
 * @author xuzhijun.online
 * @date 2019年4月19日
 */
public class FileUrlClassLoader extends URLClassLoader {

	public FileUrlClassLoader(URL[] urls, ClassLoader parent) {
		super(urls, parent);
	}

	public FileUrlClassLoader(URL[] urls) {
		super(urls);
	}

	public FileUrlClassLoader(URL[] urls, ClassLoader parent, URLStreamHandlerFactory factory) {
		super(urls, parent, factory);
	}

	public static void main(String[] args) throws ClassNotFoundException, MalformedURLException {
		String rootDir = "C:\\Users\\GoneBoy\\Desktop\\test";
		// 创建自定义文件类加载器
		File file = new File(rootDir);
		// File to URI
		URI uri = file.toURI();
		URL[] urls = { uri.toURL() };

		FileUrlClassLoader loader = new FileUrlClassLoader(urls);

		try {
			// 加载指定的class文件
			Class<?> object1 = loader.loadClass("com.xzj.classloader.DemoObj");
			System.out.println(object1.newInstance().toString());

			// 输出结果:I am DemoObj
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
