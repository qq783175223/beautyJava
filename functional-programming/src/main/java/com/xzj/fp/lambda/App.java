package com.xzj.fp.lambda;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Stream;

/**
* @author 作者: xuzhijun.com
* @createDate 创建时间：2019年3月21日 下午2:15:12
*/
public class App {
	
	public static void main(String[] args) {
		
		//模拟数据
        List<String> list = new ArrayList<String>() ;
        list.add("188-2222-9999");
        list.add("159-1235-8969");
        list.add("179-1235-8969");
        
        //实现函数
        FilterPhoneFuction phoneFuction = (phone) -> {
        	if(phone.startsWith("188")) return true;
        	return false ;
        };
        
        //调用函数
        Stream<String> stream = list.stream().filter(phoneFuction::filter);
        Iterator<String> it = stream.iterator();
        while (it.hasNext()) System.out.println(it.next());
    }

}
