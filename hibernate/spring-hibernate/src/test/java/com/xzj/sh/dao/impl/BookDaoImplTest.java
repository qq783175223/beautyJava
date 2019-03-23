package com.xzj.sh.dao.impl;

import com.xzj.sh.model.Book;
import com.xzj.sh.service.BookService;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import static org.junit.Assert.*;

/**
 * Create by xuzhijun.online on 2019/3/23.
 */
public class BookDaoImplTest {
    private ApplicationContext context=null;
    private BookService bookService=null;

    {
        context= new ClassPathXmlApplicationContext("applicationContext.xml");
        bookService=context.getBean(BookService.class);
    }
    @Test
    public void findBookById() {
        String bookName=bookService.findBookById(2);
        System.out.println(bookName);
    }

    @Test
    public void saveBook() {
        bookService.saveBook(new Book(8, "keras", "1008", 85, 100));
    }
}