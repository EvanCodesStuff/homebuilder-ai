package com.example.homebuilder.properties;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;
@ConfigurationProperties(prefix = "home")
@Component
public class HomeBuilderProps {

    private String role;
    private String system = "You are an assistant on my app "; //todo Step1: Update with system role with our apps info and an objective for the AI

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getSystem() {
        return system;
    }

    public void setSystem(String system) {
        this.system = system;
    }

}
