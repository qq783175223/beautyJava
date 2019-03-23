package com.xzj.sh.service;

import com.xzj.sh.dao.BookDao;
import com.xzj.sh.model.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Create by xuzhijun.online on 2019/3/23.
 */
@Service
public class BookServiceImpl implements BookService
{
    @Autowired
    private BookDao bookDao;
    public String findBookById(int id)
    {
        return bookDao.findBookById(id);
    }
    public void saveBook(Book book)
    {
        bookDao.saveBook(book);

    }
}
