package com.xzj.sh.service;

import com.xzj.sh.model.Book;

/**
 * Create by xuzhijun.online on 2019/3/23.
 */
public interface BookService
{
    public String findBookById(int id);
    public void saveBook(Book book);
}
