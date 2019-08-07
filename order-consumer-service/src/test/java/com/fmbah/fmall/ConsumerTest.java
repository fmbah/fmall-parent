package com.fmbah.fmall;

import com.fmbah.fmall.service.OrderService;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.io.IOException;

public class ConsumerTest {


    @Test
    public void test0() throws IOException {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("consumer.xml");
        context.start();

        OrderService orderService = (OrderService)context.getBean("orderService");
        orderService.initOrder("1");

        System.in.read();
    }

}
