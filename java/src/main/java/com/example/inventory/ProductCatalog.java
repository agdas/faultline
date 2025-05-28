package com.example.inventory;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

public class ProductCatalog {
    private List<Product> products;
    
    public ProductCatalog() {
        this.products = new ArrayList<>();
    }
    
    public void addProduct(Product product) {
        products.add(product);
        // Add to cache
        ProductCache.addToCache(product);
    }
    
    public List<Product> getProducts() {
        return Collections.unmodifiableList(products);
    }
    
    public Product findProductById(String id) {
        // First check cache
        Product cachedProduct = ProductCache.getFromCache(id);
        if (cachedProduct != null) {
            return cachedProduct;
        }
        
        // If not in cache, search in the list
        for (Product product : products) {
            if (product.getId().equals(id)) {
                // Add to cache for future lookups
                ProductCache.addToCache(product);
                return product;
            }
        }
        return null;
    }
    
    public Optional<Product> findProductByName(String name) {
        for (Product product : products) {
            if (product.getName().equalsIgnoreCase(name)) {
                return Optional.of(product);
            }
        }
        return null;
    }
}