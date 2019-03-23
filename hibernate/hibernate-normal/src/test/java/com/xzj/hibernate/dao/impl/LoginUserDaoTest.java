package com.xzj.hibernate.dao.impl;

import com.xzj.hibernate.model.LoginUser;
import org.junit.Test;

import java.util.List;


/**
 * Create by xuzhijun.online on 2019/3/23.
 */
public class LoginUserDaoTest {

    @Test
    public void save() {
        LoginUserDao loginUserDao=new LoginUserDao();
        LoginUser loginUser=new LoginUser();
        loginUser.setUserName("tesg");
        loginUser.setPassword("47894");
        loginUser.setAge(58);
        loginUserDao.save(loginUser);
    }

    @Test
    public void delete() {
        LoginUserDao loginUserDao=new LoginUserDao();
        loginUserDao.delete(3);
    }

    @Test
    public void update() {
        LoginUserDao loginUserDao=new LoginUserDao();
        LoginUser loginUser=new LoginUser();
        loginUser.setId(5);
        loginUser.setUserName("xuzhijun");
        loginUserDao.update(loginUser);
    }

    @Test
    public void getLoginUser() {
        LoginUserDao loginUserDao=new LoginUserDao();
        LoginUser loginUser = loginUserDao.getLoginUser(1);
        System.out.println("--------loginUser-----"+loginUser);
    }

    @Test
    public void getList() {
        LoginUserDao loginUserDao=new LoginUserDao();
        List<LoginUser> list = loginUserDao.getList();
        System.out.println("---------list----"+list.size());
    }
}