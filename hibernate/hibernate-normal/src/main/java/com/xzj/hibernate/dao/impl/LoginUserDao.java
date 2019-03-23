package com.xzj.hibernate.dao.impl;

import com.xzj.hibernate.dao.ILoginUserDao;
import com.xzj.hibernate.model.LoginUser;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.List;

/**
 * Create by xuzhijun.online on 2019/3/23.
 */

public class LoginUserDao implements ILoginUserDao {

    public void save(LoginUser loginUser) {
        // 读取并且解析配置文件(包含映射文件)
        Configuration configuration = new Configuration();
        // 加载默认配置文件hibernate.cfg.xml
        // configuration.configure();
        // 加载非默认配置文件hibernate.cfg.xml
        configuration.configure("hibernate2.cfg.xml");
        // 生成会话工厂(真正解析配置文件)
        SessionFactory sessionFactory = configuration.buildSessionFactory();
        // 获取Session对象
        Session session = sessionFactory.openSession();
        // 开启事务
        // 用法1
        //Transaction transaction = session.getTransaction();
        // transaction.begin();
        // 用法2   hibernate默认情况下是没有开启事务的,必须手动开启事务
        session.beginTransaction();
        // 操作CUD
        session.save(loginUser);// 持久状态
        // 提交事务
        session.getTransaction().commit();
        // 关闭资源
        session.close();// 游离状态
        sessionFactory.close();
    }

    public void delete(Integer id) {
        //创建读取文件的类
        Configuration configuration=new Configuration();
        //加载文件
        configuration.configure("hibernate2.cfg.xml");
        //获得sessionFactory对象
        SessionFactory sessionFactory = configuration.buildSessionFactory();
        //获得session
        Session session = sessionFactory.openSession();
        //开启事务
        session.beginTransaction();
        //执行操作
        LoginUser loginUser=new LoginUser();
        loginUser.setId(id);
        session.delete(loginUser);//删除状态
        //关闭事务
        session.getTransaction().commit();
        //关闭session
        session.close();
        //关闭sessionFactory
        sessionFactory.close();
    }

    public void update(LoginUser loginUser) {
        //创建读取文件的类
        Configuration configuration=new Configuration();
        //加载文件
        configuration.configure("hibernate2.cfg.xml");
        //获得sessionFactory对象
        SessionFactory sessionFactory = configuration.buildSessionFactory();
        //获得session
        Session session = sessionFactory.openSession();
        //开启事务
        session.beginTransaction();
        //执行操作
        session.update(loginUser);
        //关闭事务
        session.getTransaction().commit();
        //关闭session
        session.close();
        //关闭sessionFactory
        sessionFactory.close();
    }

    public LoginUser getLoginUser(Integer id) {
        //创建读取文件的类
        Configuration configuration=new Configuration();
        //加载文件
        configuration.configure("hibernate2.cfg.xml");
        //获得sessionFactory对象
        SessionFactory sessionFactory = configuration.buildSessionFactory();
        //获得session
        Session session = sessionFactory.openSession();
        //开启事务
        // session.beginTransaction();  查询操作不需要事务
        //执行操作
        LoginUser loginUser=(LoginUser) session.get(LoginUser.class,id);
        //关闭事务
        // session.getTransaction().commit();
        //关闭session
        session.close();
        //关闭sessionFactory
        sessionFactory.close();
        return loginUser;
    }

    public List<LoginUser> getList() {
        //创建读取文件的类
        Configuration configuration=new Configuration();
        //加载文件
        configuration.configure("hibernate2.cfg.xml");
        //获得sessionFactory对象
        SessionFactory sessionFactory = configuration.buildSessionFactory();
        //获得session
        Session session = sessionFactory.openSession();
        //开启事务
        // session.beginTransaction();
        //执行操作
        String hql="select o from com.xzj.hibernate.model.LoginUser o";
        Query query = session.createQuery(hql);
        List<LoginUser> list = query.list();
        //关闭事务
        // session.getTransaction().commit();
        //关闭session
        session.close();
        //关闭sessionFactory
        sessionFactory.close();
        return list;
    }
}