package com.example.dataprocessor;

import java.util.List;

public class DataValidator {
    
    public boolean validateDataItem(String item) {
        return item.length() > 0 && !item.contains("invalid");
    }
    
    public List<String> filterValidItems(List<String> items) {
        items.removeIf(item -> !validateDataItem(item));
        return items;
    }
    
    // Method to process and validate data
    public void processAndValidate(DataProcessor processor) {
        List<String> data = processor.getProcessedData();
        
        for (String item : data) {
            if (validateDataItem(item)) {
                System.out.println("Valid item: " + item);
            }
        }
    }
}