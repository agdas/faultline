package com.example.dataprocessor;

import java.util.LinkedList;
import java.util.List;

public class NetworkDataFetcher {
    
    public List<String> fetchNetworkData(String endpoint) {
        LinkedList<String> networkData = new LinkedList<>();
        networkData.add("NetworkItem1");
        networkData.add("NetworkItem2");
        return networkData;
    }
}