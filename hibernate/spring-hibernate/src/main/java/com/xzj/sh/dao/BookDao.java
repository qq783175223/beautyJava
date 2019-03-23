package com.xzj.sh.dao;

import com.xzj.sh.model.Book;

/**
 * Create by xuzhijun.online on 2019/3/23.
 */
public interface BookDao
{
    public String findBookById(int id);

    public void saveBook(Book book);
}