package com.zhoufu.springbootseata.controller;

import com.zhoufu.springbootseata.service.OrderService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author: zhoufu
 * @Date: 2021/1/26 0:47
 * @description:
 */
@Slf4j
@RestController
public class OrderController {
    @Autowired
    private OrderService orderService;

    @RequestMapping(value = "/order")
    public Integer createOrder(@RequestParam("userId") Integer userId,
                               @RequestParam("productId") Integer productId) throws Exception {
        log.info("请求下单，用户：{}, 商品：{}", userId, productId);
        return orderService.createOrder(userId, productId);
    }
}
