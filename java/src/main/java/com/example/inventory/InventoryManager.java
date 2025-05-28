package com.example.inventory;

import java.util.List;

public class InventoryManager {
    private ProductCatalog catalog;
    
    public InventoryManager() {
        this.catalog = new ProductCatalog();
        initializeDefaultProducts();
    }
    
    private void initializeDefaultProducts() {
        catalog.addProduct(new Product("p1", "Laptop", 999.99));
        catalog.addProduct(new Product("p2", "Smartphone", 499.99));
        catalog.addProduct(new Product("p3", "Tablet", 299.99));
    }
    
    public void applyDiscount(double percentage) {
        List<Product> products = catalog.getProducts();
        for (Product product : products) {
            double discountedPrice = product.getPrice() * (1 - percentage / 100);
            product.setPrice(discountedPrice);
        }
    }
    
    public void addNewProduct(Product product) {
        catalog.addProduct(product);
    }
    
    public ProductCatalog getCatalog() {
        return catalog;
    }
}