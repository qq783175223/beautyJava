package com.xzj.collectionssort;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @author xuzhijun.online
 * @date 2019年4月13日
 */

public class Test {
	public static void main(String[] args) {
        User user1 = new User();
        user1.setName("a");
        user1.setOrder(11);
        User user2 = new User();
        user2.setName("b");
        user2.setOrder(2);
 
        Set<User> Hset = new HashSet<User>();
        Hset.add(user2);
        Hset.add(user1);
 
        List<User> list = new ArrayList<User>();
        list.addAll(Hset);
 
 
        Collections.sort(list,new Comparator<User>(){
            public int compare(User arg0, User arg1) {
                return arg0.getOrder().compareTo(arg1.getOrder());
            }
        });
        for(User u : list){
            System.out.println(u.getName());
        }
        
        System.out.println("11.compareTo(2) = "+ user1.getOrder().compareTo(user2.getOrder()));
    }
}