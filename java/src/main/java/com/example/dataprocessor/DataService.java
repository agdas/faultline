package com.example.dataprocessor;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class DataService {
    
    public List<String> fetchDataFromSource(String source) {
        // Simulate fetching data from a source
        return new ArrayList<>(Arrays.asList("Item1", "Item2", "Item3"));
    }
    
    public void processSourceData(String source) {
        List<String> sourceData = fetchDataFromSource(source);
        DataProcessor processor = new DataProcessor(sourceData);
        processor.processData();
    }
}