package com.example.dataprocessor;

import java.util.Arrays;
import java.util.List;

public class Application {
    public static void main(String[] args) {
        DataService service = new DataService();
        service.processSourceData("database");
        
        // New feature: process network data
        NetworkDataFetcher networkFetcher = new NetworkDataFetcher();
        List<String> networkData = networkFetcher.fetchNetworkData("api/data");
        DataProcessor networkProcessor = new DataProcessor(networkData);
        networkProcessor.processData();
        
        // Using the new resource manager
        ResourceManager resourceManager = new ResourceManager();
        List<String> filePaths = Arrays.asList("data1.txt", "data2.txt", "data3.txt");
        List<String> fileContents = resourceManager.processMultipleFiles(filePaths);
        
        CacheManager.updateCache("data", fileContents);
        
        DataValidator validator = new DataValidator();
        validator.processAndValidate(networkProcessor);
        
        System.out.println("Application completed successfully");
    }
}