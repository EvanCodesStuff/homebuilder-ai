package com.example.homebuilder.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class homebuilderController {

    @GetMapping("/")
    public String helloWorld(){
        return "hello";
    }

}