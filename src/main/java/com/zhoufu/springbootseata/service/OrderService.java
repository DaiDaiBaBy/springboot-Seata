package com.zhoufu.springbootseata.service;

/**
 * @Author: zhoufu
 * @Date: 2021/1/22 16:42
 * @description:
 */
public interface OrderService {

    /**
     * 下单
     * @param userId 用户ID
     * @param productId  产品ID
     * @return int
     */
    Integer createOrder(Integer userId, Integer productId) throws Exception;
}
