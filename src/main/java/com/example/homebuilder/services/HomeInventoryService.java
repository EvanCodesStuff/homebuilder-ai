package com.example.homebuilder.services;

import com.example.homebuilder.models.HomeInventory;
import org.springframework.stereotype.Service;
import java.util.HashMap;
import java.util.Map;

@Service
public class HomeInventoryService {

    private static final Map<Integer, HomeInventory> homeInventoryMap = new HashMap<>();

    static {
        // Populate mock data
        homeInventoryMap.put(1, new HomeInventory(1, "123 Main St", "ABC Insurance", "Smith Family"));
        homeInventoryMap.put(2, new HomeInventory(2, "456 Oak Ave", "XYZ Insurance", "Johnson Family"));
        homeInventoryMap.put(3, new HomeInventory(3, "789 Pine Rd", "DEF Insurance", "Brown Family"));
        homeInventoryMap.put(4, new HomeInventory(4, "101 Elm Blvd", "GHI Insurance", "Davis Family"));
        homeInventoryMap.put(5, new HomeInventory(5, "202 Cedar Ct", "JKL Insurance", "Wilson Family"));
    }

    public HomeInventory getHomeInventory(int homeId) {
        return homeInventoryMap.get(homeId);
    }
}


