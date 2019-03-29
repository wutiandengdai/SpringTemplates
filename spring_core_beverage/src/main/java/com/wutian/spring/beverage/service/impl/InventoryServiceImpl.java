package com.wutian.spring.beverage.service.impl;

import java.util.Map;

import com.wutian.spring.beverage.data.Product;
import com.wutian.spring.beverage.repository.InventoryItemRepository;
import com.wutian.spring.beverage.service.InventoryService;

public class InventoryServiceImpl implements InventoryService {
    private final InventoryItemRepository inventoryItemRepository;

    public InventoryServiceImpl(InventoryItemRepository inventoryItemRepository){
        this.inventoryItemRepository = inventoryItemRepository;
    }

    public Map<Product, Long> getTotalInventoryOnHand() {
        return null;
    }

    public long getQuantityOnHand(String itemId) {
        return 0;
    }

    public void adjustInventory(String itemId, long quantity) {

    }
}
