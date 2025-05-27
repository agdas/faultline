package com.example.dataprocessor;

import java.util.List;

public class Application {
    public static void main(String[] args) {
        DataService service = new DataService();
        service.processSourceData("database");
        
        System.out.println("Application completed successfully");
    }
}