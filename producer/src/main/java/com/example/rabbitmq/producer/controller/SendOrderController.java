package com.example.rabbitmq.producer.controller;

import com.example.rabbitmq.common.model.Order;
import com.example.rabbitmq.producer.service.RabbitSender;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
@RequestMapping(value = "/order")
public class SendOrderController {

    @Resource
    private RabbitSender rabbitSender;

    @GetMapping("/send")
    public String sendOrderTest(){
        Order order = new Order();
        order.setId("1234567");
        order.setName("testSendOrder");
        order.setMessageId("45678900");
        rabbitSender.sendOrder(order);
        return "success";
    }
}
