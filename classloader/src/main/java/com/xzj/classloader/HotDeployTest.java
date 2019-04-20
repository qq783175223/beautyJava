package com.xzj.classloader;

/**
 * @author xuzhijun.online
 * @date 2019年4月19日
 */
public class HotDeployTest {

	public static void main(String[] args) throws ClassNotFoundException {
		String rootDir = "C:\\Users\\GoneBoy\\Desktop\\test";
		// 创建自定义文件类加载器
		FileClassLoader loader = new FileClassLoader(rootDir);
		FileClassLoader loader2 = new FileClassLoader(rootDir);

		try {
			// 加载指定的class文件,调用loadClass()
//			Class<?> object1 = loader.loadClass("com.xzj.classloader.DemoObj");
////			//在休眠的时候去修改类文件，热更新不能被体现，还是从缓存中获取之前加载过的类
//			Thread.sleep(20000);
//			Class<?> object2 = loader.loadClass("com.xzj.classloader.DemoObj");
//
//			System.out.println("loadClass->obj1:" + object1.hashCode()+"  "+object1.newInstance().toString());
//			System.out.println("loadClass->obj2:" + object2.hashCode()+"  "+object2.newInstance().toString());

			
			// 加载指定的class文件,直接调用findClass(),绕过检测机制，创建不同class对象。
			Class<?> object3 = loader.findClass("com.xzj.classloader.DemoObj");
			//在休眠的时候去修改类文件，热更新能被体现
//			Thread.sleep(20000);
			Class<?> object4 = loader2.findClass("com.xzj.classloader.DemoObj");

			System.out.println("loadClass->obj3:" + object3.hashCode()+"  "+object3.newInstance().toString());
			System.out.println("loadClass->obj4:" + object4.hashCode()+"  "+object4.newInstance().toString());

			/**
			 * 输出结果: loadClass->obj1:644117698 
			 * loadClass->obj2:644117698
			 * 
			 * findClass->obj3:723074861 
			 * findClass->obj4:895328852
			 */

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
