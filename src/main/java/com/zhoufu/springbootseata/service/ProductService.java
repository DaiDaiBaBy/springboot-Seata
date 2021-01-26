package com.zhoufu.springbootseata.service;

import com.zhoufu.springbootseata.model.Product;

/**
 * @Author: zhoufu
 * @Date: 2021/1/22 16:44
 * @description:
 */
public interface ProductService {

    /**
     * 减少 库存
     * @param productId 商品Id
     * @param amount 扣减数量
     * @return product
     */
    Product reduceStock(Integer productId, Integer amount) throws Exception;
}
