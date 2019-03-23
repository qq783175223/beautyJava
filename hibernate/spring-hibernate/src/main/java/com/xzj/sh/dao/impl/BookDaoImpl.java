package com.xzj.sh.dao.impl;

import com.xzj.sh.dao.BookDao;
import com.xzj.sh.model.Book;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

/**
 * Create by xuzhijun.online on 2019/3/23.
 *
 */
//@Transactional
@Repository
public class BookDaoImpl implements BookDao
{
    @Autowired
    private SessionFactory sessionFactory;

    //获取和当前线程绑定的Seesion
    private Session getSession()
    {
        return sessionFactory.getCurrentSession();
    }
    public String findBookById(int id)
    {
        String hql="SELECT bookName from Book where id = ?0";
        Query query=getSession().createQuery(hql).setParameter(0, id);
        String str= query.uniqueResult().toString();
        return str;
    }
    public void saveBook(Book book)
    {
        getSession().save(book);
    }
}