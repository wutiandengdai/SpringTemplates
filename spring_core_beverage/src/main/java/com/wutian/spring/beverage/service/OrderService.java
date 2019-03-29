package com.wutian.spring.beverage.service;

import java.util.Map;

import com.wutian.spring.beverage.data.Customer;
import com.wutian.spring.beverage.data.Order;

public interface OrderService {
    Order createOrder(Customer customer, Map<String, Long> items);
    Order createOrder(String customerId, Map<String, Long> items);
    Order getOrder(String orderId);
}
