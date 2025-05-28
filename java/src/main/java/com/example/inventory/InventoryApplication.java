package com.example.inventory;

import java.util.List;
import java.util.Optional;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class InventoryApplication {
    public static void main(String[] args) {
        InventoryManager manager = new InventoryManager();
        
        // Apply a 10% discount to all products
        manager.applyDiscount(10);
        
        // Add a new product
        manager.addNewProduct(new Product("p4", "Headphones", 99.99));
        
        // New feature: bulk add promotional products
        addPromotionalProducts(manager);
        
        // Display all products
        ProductCatalog catalog = manager.getCatalog();
        for (Product product : catalog.getProducts()) {
            System.out.println(product.getId() + ": " + product.getName() + " - $" + product.getPrice());
        }
        
        // New feature: find product by name and apply special discount
        applySpecialDiscount(catalog, "Laptop");
        
        // New feature: Update prices in parallel
        updatePricesInParallel(catalog);
    }
    
    private static void addPromotionalProducts(InventoryManager manager) {
        List<Product> promoProducts = List.of(
            new Product("promo1", "Wireless Mouse", 29.99),
            new Product("promo2", "Keyboard", 49.99)
        );
        
        for (Product product : promoProducts) {
            manager.addNewProduct(product);
        }
    }
    
    private static void applySpecialDiscount(ProductCatalog catalog, String productName) {
        Optional<Product> productOpt = catalog.findProductByName(productName);
        if (productOpt.isPresent()) {
            Product product = productOpt.get();
            double specialPrice = product.getPrice() * 0.75; // 25% off
            product.setPrice(specialPrice);
            System.out.println("Applied special discount to " + product.getName());
        } else {
            System.out.println("Product not found: " + productName);
        }
    }
    
    private static void updatePricesInParallel(ProductCatalog catalog) {
        ExecutorService executor = Executors.newFixedThreadPool(4);
        
        executor.submit(new PriceUpdateWorker("p1", 899.99));
        executor.submit(new PriceUpdateWorker("p1", 949.99));
        executor.submit(new PriceUpdateWorker("p2", 449.99));
        executor.submit(new PriceUpdateWorker("p2", 479.99));
        
        executor.shutdown();
    }
}