package com.xzj;

import java.math.BigDecimal;
import java.util.Objects;

/**
 * 类 {@code OrderService} 订单服务层.
 *
 * <p> 主要包括 创建订单、取消订单、查询订单等功能更
 *
 * @see Order
 * @author <a href="mailto:mengday.zhang@gmail.com">Mengday Zhang</a>
 * @since 2018/5/12
 */
public class OrderService {

    /** 默认数量 {@value} */
    private static final Integer QUANTITY = 1;

    /**
     * 创建订单.
     *
     * <p> 创建订单需要传用户id和商品列表(商品id和商品数量).
     *
     * <p><pre>{@code
     *  演示如何使用该方法
     *  List<Goods> items = new ArrayList<>();
     *  Goods goods = new Goods(1L, BigDecimal.ONE);
     *  Goods goods2 = new Goods(2L, BigDecimal.TEN);
     *  items.add(goods);
     *  items.add(goods2);
     *
     *  Order order1 = new Order();
     *  order.setUserId("1");
     *  order.setItems(items);
     *  OrderService#createOrder(order);
     * }
     * </pre>
     *
     * @param order 订单信息
     * @throws NullPointerException 参数信息为空
     * @exception IllegalArgumentException  数量不合法
     * @return 是否创建成功
     * @version 1.0
     * @see {@link Order}
     */
    public boolean createOrder(Order order) throws IllegalArgumentException{
        Objects.requireNonNull(order);

        List<Goods> items = order.getItems();
        items.forEach(goods -> {
            BigDecimal quantity = goods.getQuantity();
            if (quantity == null || BigDecimal.ZERO.compareTo(quantity) == 0) {
                throw new IllegalArgumentException();
            }
        });

        System.out.println("create order...");

        return true;
    }
}