package com.xzj.classloader.hotdeploy;


/**
 * @author xuzhijun.online
 * @date 2019年4月19日
 */
public class HotDeployTest {
	
	

	public static void main(String[] args) throws ClassNotFoundException {
		String rootDir = "C:\\Users\\GoneBoy\\Desktop\\test";
		// 创建自定义文件类加载器
		HotDeployClassLoader loader = new HotDeployClassLoader(rootDir);
		try {
			// 加载指定的class文件,调用loadClass()
			Class<?> object1 = loader.loadClass("com.xzj.classloader.DemoObj");
			
			Thread.sleep(20000);
			
//			//在休眠的时候去修改类文件
			Class<?> object2 = loader.loadClass("com.xzj.classloader.DemoObj");
			
			System.out.println("loadClass->obj1:" + object1.hashCode()+"  "+object1.newInstance().toString());
			System.out.println("loadClass->obj2:" + object2.hashCode()+"  "+object2.newInstance().toString());
			

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
