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
/**
 * @EnableDiscoveryClient和@EnableEurekaClient
 * 共同点就是：都是能够让注册中心能够发现，扫描到改服务。
 * 不同点：@EnableEurekaClient只适用于Eureka作为注册中心，@EnableDiscoveryClient 可以是其他注册中心。
 */
@EnableDiscoveryClient
public class PaymantMain8001 {
    public static void main(String[] args) {
        SpringApplication.run(PaymantMain8001.class, args);
    }
}
