package com.atguigu.springcloud.controller;

import com.atguigu.springcloud.entities.CommonResult;
import com.atguigu.springcloud.entities.Payment;
import com.atguigu.springcloud.service.PaymentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author liuqi
 * @create 2020-04-20 0:32
 */
@RestController
@Slf4j
public class PaymentController {

    @Resource
    private PaymentService paymentService;

    @Resource
    private DiscoveryClient discoveryClient;

    @Value("${server.port}")
    private String serverPort;

    /**
     * PostMapping和RequestMapping的区别：主要是区分请求类别，代码可读性高
     * PostMapping用于将HTTP POST请求映射到特定处理程序方法的注释
     * 注解作用：@PostMapping = @RequestMapping(method = RequestMethod.POST)。
     * 类似还有@PutMapping、@DeleteMapping、@PatchMapping、@GetMapping
     * 必须加上value=
     *
     * @param payment
     * @return
     */
    @PostMapping(value = "/payment/create")
    public CommonResult create(@RequestBody Payment payment) {
        int result = paymentService.add(payment);
        log.info("************插入结果{}", result);
        if (result > 0) {
            return new CommonResult(200, "添加成功,serverPort:" + serverPort, result);
        } else {
            return new CommonResult(500, "添加失败", null);
        }
    }

    /**
     * 注解作用：@PathVariable，从路径里面去获取变量
     *
     * @param id
     * @return
     */
    @GetMapping(value = "/payment/get/{id}")
    public CommonResult get(@PathVariable("id") Long id) {
        Payment payment = paymentService.getPaymentById(id);
        log.info("**************查询结果{}", payment);
        if (payment != null) {
            return new CommonResult(200, "查询成功,serverPort:" + serverPort, payment);
        } else {
            return new CommonResult(500, "查询结果为空，id是：" + id, null);
        }
    }

    @GetMapping(value = "/payment/discovery")
    public Object discovery() {

        List<String> services = discoveryClient.getServices();
        for (String service : services) {
            log.info("service : {}", service);
        }

        List<ServiceInstance> instances = discoveryClient.getInstances("CLOUD-PAYMENT-SERVICE");
        for (ServiceInstance instance : instances) {
//            instance.getInstanceId()
            log.info("{},{},{},{}", instance.getServiceId(), instance.getHost(), instance.getPort(), instance.getUri());
        }

        return this.discoveryClient;
    }
}
