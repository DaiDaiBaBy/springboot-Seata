package com.zhoufu.springbootseata.service.impl;

import com.baomidou.dynamic.datasource.annotation.DS;
import com.zhoufu.springbootseata.mapper.OrdersMapper;
import com.zhoufu.springbootseata.model.Orders;
import com.zhoufu.springbootseata.model.Product;
import com.zhoufu.springbootseata.service.AccountService;
import com.zhoufu.springbootseata.service.OrderService;
import com.zhoufu.springbootseata.service.ProductService;
import io.seata.core.context.RootContext;
import io.seata.spring.annotation.GlobalTransactional;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

/**
 * @Author: zhoufu
 * @Date: 2021/1/22 16:44
 * @description:
 */
@Slf4j
@Service
public class OrderServiceImpl implements OrderService {
    @Autowired
    private OrdersMapper ordersMapper;
    @Autowired
    private AccountService accountService;
    @Autowired
    private ProductService productService;

    @DS(value = "order-ds")
    @GlobalTransactional // seata全局事务注解
    public Integer createOrder(Integer userId, Integer productId) throws Exception {
        // 购买数量暂时设置为1
        Integer amount = 1;
        // 全局唯一的事务ID
        log.info("当前 UXD：{}" , RootContext.getXID());
        // 调取服务  减 库存
        Product product = productService.reduceStock(productId, amount);

        // 调取服务 减 余额    商品单价 * 购买数量
        accountService.reduceBalance(userId, product.getPrice() * amount);

        // 下订单 - 本地下订单
        Orders orders = new Orders();
        orders.setUserId(userId);
        orders.setProductId(productId);
        orders.setPayAmount(BigDecimal.valueOf(product.getPrice()).multiply(new BigDecimal(amount)).intValue());

        ordersMapper.insertSelective(orders);
        log.info("下订单：{}" , orders.getId());
        // 返回订单号
        return orders.getId();
    }
}
