package com.xzj.classloader.hotdeploy;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;

/**
 * @author xuzhijun.online
 * @date 2019年4月19日
 */
public class HotDeployClassLoader extends ClassLoader {
	// 缓存加载class文件的最后最新修改时间
	public static Map<String, Long> cacheLastModifyTimeMap = new HashMap<String, Long>();

	private String rootDir;

	public HotDeployClassLoader(String rootDir) {
		this.rootDir = rootDir;
	}
	
	@Override
	public Class<?> loadClass(String name) throws ClassNotFoundException {
		// 热部署，类文件被修改过则重新创建类加载器去加载
		if(name.startsWith("com.xzj")) {
			if (cacheLastModifyTimeMap.containsKey(name) && classFileIsModify(name) == true) {
				return new HotDeployClassLoader(this.rootDir).findClass(name);
			}
			// 缓存加载class文件的最后修改时间
			long lastModifyTime = getClassLastModifyTime(name);
			cacheLastModifyTimeMap.put(name, lastModifyTime);
			return super.loadClass(name);
		}else {
            //得到系统默认的加载cl，即AppClassLoader
//            ClassLoader system = ClassLoader.getSystemClassLoader();
            ClassLoader system = Thread.currentThread().getContextClassLoader();
            return system.loadClass(name);
		}
	}

	/**
	 * 编写findClass方法的逻辑
	 * 
	 * @param name
	 * @return
	 * @throws ClassNotFoundException
	 */
	@Override
	protected Class<?> findClass(String name) throws ClassNotFoundException {
		// 获取类的class文件字节数组
		byte[] classData = getClassData(name);
		if (classData == null) {
			throw new ClassNotFoundException();
		} else {
			// 直接生成class对象
			return defineClass(name, classData, 0, classData.length);
		}
	}
	
    /**
     * @param name
     * @return .class文件最新的修改时间
     */
    private long getClassLastModifyTime(String name){
        String path = classNameToPath(name);
        File file = new File(path);
        if(!file.exists()){
           throw new RuntimeException(new FileNotFoundException(name));
        }
        return file.lastModified();
    }


	/**
	 * 判断这个文件跟上次比是否修改过
	 * @return
	 */
	private boolean classFileIsModify(String name) {
        long lastmodify = getClassLastModifyTime(name);
        long previousModifyTime = cacheLastModifyTimeMap.get(name);
        if(lastmodify > previousModifyTime){
            return true;
       }
       return false;
	}

	/**
	 * 编写获取class文件并转换为字节码流的逻辑
	 * 
	 * @param className
	 * @return
	 */
	private byte[] getClassData(String className) {
		// 读取类文件的字节
		String path = classNameToPath(className);
		InputStream ins = null;
		try {
			ins = new FileInputStream(path);
			ByteArrayOutputStream baos = new ByteArrayOutputStream();
			int bufferSize = 4096;
			byte[] buffer = new byte[bufferSize];
			int bytesNumRead = 0;
			// 读取类文件的字节码
			while ((bytesNumRead = ins.read(buffer)) != -1) {
				baos.write(buffer, 0, bytesNumRead);
			}
			return baos.toByteArray();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (ins != null) {
				try {
					ins.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		return null;
	}

	/**
	 * 类文件的完全路径
	 * 
	 * @param className
	 * @return
	 */
	private String classNameToPath(String className) {
		return rootDir + File.separatorChar + className.replace('.', File.separatorChar) + ".class";
	}

}
