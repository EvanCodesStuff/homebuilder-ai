package com.example.homebuilder.controller;

import com.example.homebuilder.models.HomeInventory;
import com.example.homebuilder.models.HomeRebuild;
import com.example.homebuilder.models.DawgModel;
import com.example.homebuilder.services.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class homebuilderController {

    @GetMapping("/")
    public String helloWorld() {
        return "hello";
    }

    @Autowired
    private HomeInventoryService homeInventoryService;

    @Autowired
    private HomeRebuildService homeRebuildService;

    @Autowired
    private DawgService dawgServicing;

    @GetMapping("/{HOME_ID}/inventory")
    public ResponseEntity<HomeInventory> getHomeInventory(@PathVariable("HOME_ID") int homeId) {
        HomeInventory homeInventory = homeInventoryService.getHomeInventory(homeId);
        if (homeInventory != null) {
            return ResponseEntity.ok(homeInventory);
        } else {
            return ResponseEntity.notFound().build();
        }
    }
    //TODO step 2 update controller with dog functionality
    @GetMapping("/{HOME_ID}/rebuildStatus")
    public ResponseEntity<HomeRebuild> getRebuild(@PathVariable("HOME_ID") int homeId) {
        HomeRebuild homeRebuild = homeRebuildService.getRebuild(homeId);
        if (homeRebuild != null) {
            return ResponseEntity.ok(homeRebuild);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("/{FAMILY}/dogFinding")
    public ResponseEntity<DawgModel> getDawg(@PathVariable("FAMILY") String family) {
        DawgModel dawgFinder = dawgServicing.getDawgModel(family);
        if (family != null) {
            return ResponseEntity.ok(dawgFinder);
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}