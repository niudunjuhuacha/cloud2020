package com.atguigu.springcloud.service;

import com.atguigu.springcloud.entities.Payment;

/**
 * @author liuqi
 * @create 2020-04-20 0:27
 */
public interface PaymentService {
    int add(Payment payment);
    Payment getPaymentById(Long id);
}
