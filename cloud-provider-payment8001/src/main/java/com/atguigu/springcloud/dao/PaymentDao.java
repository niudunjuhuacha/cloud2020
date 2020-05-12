package com.atguigu.springcloud.dao;

import com.atguigu.springcloud.entities.Payment;
import org.apache.ibatis.annotations.Mapper;

/**
 * @author liuqi
 * @create 2020-04-20 0:19
 */
@Mapper
public interface PaymentDao {
    int create(Payment payment);
    Payment selectPaymentById(Long id);
}
