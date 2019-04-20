package com.xzj.test;

import java.io.File;
import java.util.StringTokenizer;

/**
 * Hello world!
 *
 */
public class Test 
{
    public static void main( String[] args )
    {
    	getExtDirs();
    	System.out.println(System.getProperty("jdbc.drivers"));
    }
    
  //ExtClassLoader类中获取路径的代码
    private static File[] getExtDirs() {
         //加载<JAVA_HOME>/lib/ext目录中的类库
         String s = System.getProperty("java.ext.dirs");
         File[] dirs;
         if (s != null) {
             StringTokenizer st =
                 new StringTokenizer(s, File.pathSeparator);
             int count = st.countTokens();
             dirs = new File[count];
             for (int i = 0; i < count; i++) {
                 dirs[i] = new File(st.nextToken());
             }
         } else {
             dirs = new File[0];
         }
         return dirs;
     }

}
