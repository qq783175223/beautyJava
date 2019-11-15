package com.xzj.demo.reentrantreadwritelock;

import java.util.ArrayList;
import java.util.List;

/**
 * Create by xuzhijun.online on 2019/11/15.
 */
public class ShoppingCart {
    private List<String> products = new ArrayList<String>();

    public String getProduct(int i) {
        return products.get(i);
    }

    public void addProduct(String name) {
        products.add(name);
    }
}
