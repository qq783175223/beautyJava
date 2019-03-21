package com.xzj.fp.callable;
/**
* @author 作者: xuzhijun.com
* @createDate 创建时间：2019年3月21日 下午3:08:15
*/

public interface MyCallable<A,B,V> {
	
	V call(A a, B b) throws Exception;
}
