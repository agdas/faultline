package com.example.inventory;

public class PriceUpdateWorker implements Runnable {
    private final String productId;
    private final double newPrice;
    
    public PriceUpdateWorker(String productId, double newPrice) {
        this.productId = productId;
        this.newPrice = newPrice;
    }
    
    @Override
    public void run() {
        ProductCache.updatePriceInCache(productId, newPrice);
    }
}