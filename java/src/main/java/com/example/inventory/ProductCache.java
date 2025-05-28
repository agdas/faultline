package com.example.inventory;

import java.util.HashMap;
import java.util.Map;

public class ProductCache {
    private static Map<String, Product> cache = new HashMap<>();
    
    public static void addToCache(Product product) {
        cache.put(product.getId(), product);
    }
    
    public static Product getFromCache(String id) {
        return cache.get(id);
    }
    
    public static void clearCache() {
        cache.clear();
    }
    
    public static void updatePriceInCache(String id, double newPrice) {
        Product product = cache.get(id);
        if (product != null) {
            product.setPrice(newPrice);
            cache.put(id, product);
        }
    }
}