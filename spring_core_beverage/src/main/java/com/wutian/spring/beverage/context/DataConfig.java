package com.wutian.spring.beverage.context;

import com.wutian.spring.beverage.repository.CustomerRepository;
import com.wutian.spring.beverage.repository.InventoryItemRepository;
import com.wutian.spring.beverage.repository.SalesOrderRepository;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Configuration for repositories
 */
@Configuration
class DataConfig{

    @Bean
    public InventoryItemRepository getInventoryItemRepository() {
        return new InventoryItemRepository();
    }

    @Bean
    public CustomerRepository getCustomerRepository() {
        return new CustomerRepository();
    }

    @Bean
    public SalesOrderRepository getSalesOrderRepository() {
        return new SalesOrderRepository();
    }

}