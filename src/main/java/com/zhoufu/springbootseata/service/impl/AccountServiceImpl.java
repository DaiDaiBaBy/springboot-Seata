package com.zhoufu.springbootseata.service.impl;

import com.baomidou.dynamic.datasource.annotation.DS;
import com.zhoufu.springbootseata.mapper.AccountMapper;
import com.zhoufu.springbootseata.model.Account;
import com.zhoufu.springbootseata.service.AccountService;
import io.seata.core.context.RootContext;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

/**
 * @Author: zhoufu
 * @Date: 2021/1/22 16:43
 * @description:
 */
@Service
@Slf4j
public class AccountServiceImpl implements AccountService {
    @Autowired
    private AccountMapper accountMapper;

    @DS(value = "account-ds")
    public void reduceBalance(Integer userId, Integer money) throws Exception {
        log.info("当前 XID：{}" , RootContext.getXID());

        // 检查余额
        Account account = accountMapper.selectAccountByUserId(userId);
        log.info("账户余额：{}， 下单金额：{}", account.getBalance(), money);
        if (account.getBalance().doubleValue() < money){
            throw new Exception("余额不足");
        }

        // 扣除 余额
        int balance = accountMapper.reduceBalance(userId, money);
        if (balance == 0){
            throw new Exception("余额不足");
        }
        log.info("扣除用户 {} 余额成功", userId);
    }
}
