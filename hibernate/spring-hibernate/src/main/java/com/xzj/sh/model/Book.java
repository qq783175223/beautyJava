package com.xzj.sh.model;


import javax.persistence.Entity;

/**
 * Create by xuzhijun.online on 2019/3/23.
 */
@Entity
public class Book
{
    private Integer id;
    private String bookName;
    private String isbn;
    private int price;
    private int stock;
    public Integer getId()
    {
        return id;
    }
    public void setId(Integer id)
    {
        this.id = id;
    }
    public String getBookName()
    {
        return bookName;
    }
    public void setBookName(String bookName)
    {
        this.bookName = bookName;
    }
    public String getIsbn()
    {
        return isbn;
    }
    public void setIsbn(String isbn)
    {
        this.isbn = isbn;
    }
    public int getPrice()
    {
        return price;
    }
    public void setPrice(int price)
    {
        this.price = price;
    }
    public int getStock()
    {
        return stock;
    }
    public void setStock(int stock)
    {
        this.stock = stock;
    }
    public Book(Integer id, String bookName, String isbn, int price, int stock)
    {
        super();
        this.id = id;
        this.bookName = bookName;
        this.isbn = isbn;
        this.price = price;
        this.stock = stock;
    }
}