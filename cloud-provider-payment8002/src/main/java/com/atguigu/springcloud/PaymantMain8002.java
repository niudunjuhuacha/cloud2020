package com.atguigu.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * @author liuqi
 * @create 2020-04-19 23:28
 */
@SpringBootApplication
@EnableEurekaClient
@EnableDiscoveryClient
public class PaymantMain8002 {
    public static void main(String[] args) {
        SpringApplication.run(PaymantMain8002.class, args);
    }
}
