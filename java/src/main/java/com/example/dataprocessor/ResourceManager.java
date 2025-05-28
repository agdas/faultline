package com.example.dataprocessor;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ResourceManager {
    private List<BufferedReader> activeReaders = new ArrayList<>();
    
    public String readDataFromFile(String filePath) {
        StringBuilder content = new StringBuilder();
        try {
            BufferedReader reader = new BufferedReader(new FileReader(filePath));
            // Store the reader in the list of active readers
            activeReaders.add(reader);
            
            String line;
            while ((line = reader.readLine()) != null) {
                content.append(line).append("\n");
            }
            
        } catch (IOException e) {
            System.err.println("Error reading file: " + e.getMessage());
        }
        
        return content.toString();
    }
    
    // Method to process multiple files
    public List<String> processMultipleFiles(List<String> filePaths) {
        List<String> results = new ArrayList<>();
        for (String path : filePaths) {
            results.add(readDataFromFile(path));
        }
        return results;
    }
}