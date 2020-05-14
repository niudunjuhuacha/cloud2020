package com.atguigu.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * @author liuqi
 * @create 2020-04-19 23:28
 */
@SpringBootApplication
@EnableEurekaClient
public class PaymantMain8001 {
    public static void main(String[] args) {
        SpringApplication.run(PaymantMain8001.class, args);
    }
}
