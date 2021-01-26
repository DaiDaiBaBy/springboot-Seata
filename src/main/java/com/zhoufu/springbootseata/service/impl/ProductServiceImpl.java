package com.zhoufu.springbootseata.service.impl;

import com.baomidou.dynamic.datasource.annotation.DS;
import com.zhoufu.springbootseata.mapper.ProductMapper;
import com.zhoufu.springbootseata.model.Product;
import com.zhoufu.springbootseata.service.ProductService;
import io.seata.core.context.RootContext;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


/**
 * @Author: zhoufu
 * @Date: 2021/1/22 16:44
 * @description:
 */
@Slf4j
@Service
public class ProductServiceImpl implements ProductService {
    @Autowired
    private ProductMapper productMapper;

    @DS(value = "product-ds")
    public Product reduceStock(Integer productId, Integer amount) throws Exception {
        log.info("当前 XID ： {}" , RootContext.getXID());

        //检查库存
        Product product = productMapper.selectByPrimaryKey(productId);
        log.info("当前库存量：{}, 购买量：{}", product.getStock(), amount);
        if (product.getStock() < amount){
            throw new Exception("库存不足");
        }

        //扣减库存
        int stock = productMapper.reduceStock(productId, amount);
        // 扣除成功
        if (stock == 0){
            throw new Exception("库存不足");
        }
        // 扣减成功
        log.info("扣减 {} 库存成功", productId);
        return product;
    }
}
