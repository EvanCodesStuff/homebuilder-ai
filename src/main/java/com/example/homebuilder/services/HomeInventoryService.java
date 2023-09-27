package com.example.homebuilder.services;

import com.example.homebuilder.models.HomeInventory;
import org.springframework.stereotype.Service;
import java.util.HashMap;
import java.util.Map;

@Service
public class HomeInventoryService {

    private static final Map<Long, HomeInventory> homeInventoryMap = new HashMap<>();

    static {
        // Populate mock data
        homeInventoryMap.put(1L, new HomeInventory(1L, "123 Main St", "ABC Insurance", "Smith Family"));
        homeInventoryMap.put(2L, new HomeInventory(2L, "456 Oak Ave", "XYZ Insurance", "Johnson Family"));
        homeInventoryMap.put(3L, new HomeInventory(3L, "789 Pine Rd", "DEF Insurance", "Brown Family"));
        homeInventoryMap.put(4L, new HomeInventory(4L, "101 Elm Blvd", "GHI Insurance", "Davis Family"));
        homeInventoryMap.put(5L, new HomeInventory(5L, "202 Cedar Ct", "JKL Insurance", "Wilson Family"));
    }

    public HomeInventory getHomeInventory(Long homeId) {
        return homeInventoryMap.get(homeId);
    }
}
