package com.example.dataprocessor;

import java.util.ArrayList;
import java.util.List;

public class DataProcessor {
    private final ArrayList<String> dataItems;
    
    public DataProcessor(List<String> items) {
        this.dataItems = (ArrayList<String>) items;
    }
    
    public void processData() {
        for (int i = 0; i < dataItems.size(); i++) {
            String item = dataItems.get(i);
            System.out.println("Processing: " + item);
        }
    }
    
    public void addItem(String item) {
        dataItems.add(item);
    }
    
    public List<String> getProcessedData() {
        return dataItems;
    }
}