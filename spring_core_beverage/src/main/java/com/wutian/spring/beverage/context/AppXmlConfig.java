package com.wutian.spring.beverage.context;

import com.wutian.spring.beverage.service.OrderService;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class AppXmlConfig{

    public static void main(String[] args){
        ApplicationContext context = new ClassPathXmlApplicationContext("classpath:application-config.xml");
            
        OrderService orderService = (OrderService) context.getBean(OrderService.class);
        System.out.println(orderService == null ? "Iniation Failed!" : "Done!");
        ((AbstractApplicationContext) context).close();
    }
}