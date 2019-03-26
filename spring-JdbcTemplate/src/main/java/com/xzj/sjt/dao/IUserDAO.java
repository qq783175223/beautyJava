package com.xzj.sjt.dao;

import com.xzj.sjt.model.User;

import java.util.List;

/**
 * Create by xuzhijun.online on 2019/3/26.
 */

public interface IUserDAO {

    public void addUser(User user);

    public void deleteUser(int id);

    public void updateUser(User user);

    public String searchUserName(int id);

    public User searchUser(int id);

    public List<User> findAll();

}