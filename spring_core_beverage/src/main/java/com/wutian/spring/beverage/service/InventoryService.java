package com.wutian.spring.beverage.service;

import java.util.Map;

import com.wutian.spring.beverage.data.Product;

public interface InventoryService {
    Map<Product, Long> getTotalInventoryOnHand();
    long getQuantityOnHand(String itemId);
    void adjustInventory(String itemId, long quantity);
}
