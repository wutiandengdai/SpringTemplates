package com.wutian.spring.beverage.service.impl;

import java.util.Map;

import com.wutian.spring.beverage.data.Customer;
import com.wutian.spring.beverage.data.Order;
import com.wutian.spring.beverage.repository.CustomerRepository;
import com.wutian.spring.beverage.repository.SalesOrderRepository;
import com.wutian.spring.beverage.service.InventoryService;
import com.wutian.spring.beverage.service.OrderService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Service annotation on implementing class, not on interface
 * With @Service, no need for @Bean on getter
 */
@Service
public class OrderServiceImpl implements OrderService {
    private final InventoryService inventoryService;
    private final CustomerRepository customerRepository;
    private final SalesOrderRepository salesOrderRepository;

    @Autowired
    public OrderServiceImpl(InventoryService inventoryService, CustomerRepository customerRepository, SalesOrderRepository salesOrderRepository) {
        this.inventoryService = inventoryService;
        this.customerRepository = customerRepository;
        this.salesOrderRepository = salesOrderRepository;
    }

    public Order createOrder(Customer customer, Map<String, Long> items) {
        return null;
    }

    public Order createOrder(String customerId, Map<String, Long> items) {
        return null;
    }

    public Order getOrder(String orderId) {
        return null;
    }
}
