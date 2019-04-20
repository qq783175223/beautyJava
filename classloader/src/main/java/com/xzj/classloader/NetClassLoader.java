package com.xzj.classloader;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;

/**
 * @author xuzhijun.online
 * @date 2019年4月19日
 */
public class NetClassLoader extends ClassLoader {

	private String url;// class文件的URL

	public NetClassLoader(String url) {
		this.url = url;
	}

	@Override
	protected Class<?> findClass(String name) throws ClassNotFoundException {
		byte[] classData = getClassDataFromNet(name);
		if (classData == null) {
			throw new ClassNotFoundException();
		} else {
			return defineClass(name, classData, 0, classData.length);
		}
	}

	/**
	 * 从网络获取class文件
	 * 
	 * @param className
	 * @return
	 */
	private byte[] getClassDataFromNet(String className) {
		String path = classNameToPath(className);
		try {
			URL url = new URL(path);
			InputStream ins = url.openStream();
			ByteArrayOutputStream baos = new ByteArrayOutputStream();
			int bufferSize = 4096;
			byte[] buffer = new byte[bufferSize];
			int bytesNumRead = 0;
			// 读取类文件的字节
			while ((bytesNumRead = ins.read(buffer)) != -1) {
				baos.write(buffer, 0, bytesNumRead);
			}
			// 这里省略解密的过程.......
			return baos.toByteArray();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	private String classNameToPath(String className) {
		// 得到类文件的URL
		return url + "/" + className.replace('.', '/') + ".class";
	}

	
	public static void main(String[] args) throws IOException {
		
		NetClassLoader loader = new NetClassLoader("https://raw.githubusercontent.com/xuzhijvn/primary-java/master/classloader/class");
		
//		byte[] data = loader.getClassDataFromNet("com.xzj.classloader.README");
		
//		FileUtils.writeByteArrayToFile(new File("C:\\Users\\GoneBoy\\Desktop\\test\\README.md"), data);
		
		try {
			// 加载指定的class文件
			Class<?> object1 = loader.loadClass("com.xzj.classloader.Coder");
			System.out.println(object1.newInstance().toString());

			// 输出结果:I am DemoObj
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
