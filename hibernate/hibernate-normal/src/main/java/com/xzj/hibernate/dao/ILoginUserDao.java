package com.xzj.hibernate.dao;

import com.xzj.hibernate.model.LoginUser;

import java.util.List;

/**
 * Create by xuzhijun.online on 2019/3/23.
 */
public interface  ILoginUserDao {
    void save(LoginUser loginUser);
    void delete(Integer id);
    void update(LoginUser loginUser);
    LoginUser getLoginUser(Integer id);
    List<LoginUser> getList();
}
