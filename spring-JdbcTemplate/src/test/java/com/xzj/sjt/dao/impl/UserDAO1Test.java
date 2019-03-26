package com.xzj.sjt.dao.impl;

import com.xzj.sjt.dao.IUserDAO;
import com.xzj.sjt.model.User;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

/**
 * Create by xuzhijun.online on 2019/3/26.
 */
public class UserDAO1Test {

    private ApplicationContext context=null;
    private IUserDAO dao1=null;

    {
        context= new ClassPathXmlApplicationContext("appliactionContext.xml");
        dao1=context.getBean(UserDAO1.class);
    }

    @org.junit.Test
    public void addUser() {
        User user=new User();
        user.setId(6);
        user.setUsername("admin");
        user.setPassword("123456");
        dao1.addUser(user);
    }

    @org.junit.Test
    public void deleteUser() {
        dao1.deleteUser(3);
    }

    @org.junit.Test
    public void updateUser() {
        User user=new User();
        user.setId(6);
        user.setUsername("admin");
        user.setPassword("admin");
        dao1.updateUser(user);
    }

    @org.junit.Test
    public void searchUserName() {
        String name=dao1.searchUserName(6);
        System.out.println(name);
    }

    @org.junit.Test
    public void findAll() {
        List<User> users=dao1.findAll();
        System.out.println(users.size());
    }

    @org.junit.Test
    public void searchUser() {
        User user = dao1.searchUser(6);
        System.out.println(user.getUsername());
    }
}