package com.zhoufu.springbootseata.service;

import java.math.BigDecimal;

/**
 * @Author: zhoufu
 * @Date: 2021/1/22 16:42
 * @description:
 */
public interface AccountService {

    /**
     * 减 余额
     * @param userId 用户id
     * @param money 扣减金额
     */
    void  reduceBalance(Integer userId, Integer money) throws Exception;
}
