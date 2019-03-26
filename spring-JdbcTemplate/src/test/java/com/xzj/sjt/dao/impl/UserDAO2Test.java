package com.xzj.sjt.dao.impl;

import com.xzj.sjt.dao.IUserDAO;
import com.xzj.sjt.model.User;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

/**
 * Create by xuzhijun.online on 2019/3/26.
 */
public class UserDAO2Test {

    private ApplicationContext context=null;
    private IUserDAO dao2=null;

    {
        context= new ClassPathXmlApplicationContext("appliactionContext.xml");
        dao2=(IUserDAO)context.getBean("userDao2");
    }

    @org.junit.Test
    public void addUser() {
        User user=new User();
        user.setId(9);
        user.setUsername("admin");
        user.setPassword("123456");
        dao2.addUser(user);
    }

    @org.junit.Test
    public void deleteUser() {
        dao2.deleteUser(9);
    }

    @org.junit.Test
    public void updateUser() {
        User user=new User();
        user.setId(6);
        user.setUsername("徐植君");
        user.setPassword("admin");
        dao2.updateUser(user);
    }

    @org.junit.Test
    public void searchUserName() {
        String name=dao2.searchUserName(6);
        System.out.println(name);
    }

    @org.junit.Test
    public void findAll() {
        List<User> users=dao2.findAll();
        System.out.println(users.size());
    }

    @org.junit.Test
    public void searchUser() {
        User user = dao2.searchUser(6);
        System.out.println(user.getUsername());
    }
}