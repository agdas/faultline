package com.example.inventory;

public class InventoryApplication {
    public static void main(String[] args) {
        InventoryManager manager = new InventoryManager();
        
        // Apply a 10% discount to all products
        manager.applyDiscount(10);
        
        // Add a new product
        manager.addNewProduct(new Product("p4", "Headphones", 99.99));
        
        // Display all products
        ProductCatalog catalog = manager.getCatalog();
        for (Product product : catalog.getProducts()) {
            System.out.println(product.getId() + ": " + product.getName() + " - $" + product.getPrice());
        }
    }
}