package com.example.dataprocessor;

import java.util.HashMap;
import java.util.Map;

public class CacheManager {
    private static Map<String, Object> cache = new HashMap<>();
    
    public static void updateCache(String key, Object value) {
        if (cache.containsKey(key)) {
            cache.remove(key);
        }
        
        // Add the new value
        cache.put(key, value);
    }
    
    public static Object getCachedValue(String key) {
        return cache.get(key);
    }
    
    // Method to clear specific entries
    public static void clearCacheEntry(String key) {
        cache.remove(key);
    }
}