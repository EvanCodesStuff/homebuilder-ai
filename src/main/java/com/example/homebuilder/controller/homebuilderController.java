package com.example.homebuilder.controller;

import com.example.homebuilder.models.HomeInventory;
import com.example.homebuilder.services.HomeInventoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class homebuilderController {

    @GetMapping("/")
    public String helloWorld(){
        return "hello";
    }
    @Autowired
    private HomeInventoryService homeInventoryService;

    @GetMapping("/{HOME_ID}/inventory")
    public ResponseEntity<HomeInventory> getHomeInventory(@PathVariable("HOME_ID") Long homeId) {
        HomeInventory homeInventory = homeInventoryService.getHomeInventory(homeId);
        if (homeInventory != null) {
            return ResponseEntity.ok(homeInventory);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

}