package com.example.inventory;

import java.util.ArrayList;
import java.util.List;

public class ProductCatalog {
    private List<Product> products;
    
    public ProductCatalog() {
        this.products = new ArrayList<>();
    }
    
    public void addProduct(Product product) {
        products.add(product);
    }
    
    public List<Product> getProducts() {
        return products;
    }
    
    public Product findProductById(String id) {
        for (Product product : products) {
            if (product.getId().equals(id)) {
                return product;
            }
        }
        return null;
    }
}