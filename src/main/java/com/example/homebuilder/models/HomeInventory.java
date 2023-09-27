package com.example.homebuilder.models;

public class HomeInventory {


    public HomeInventory(Long homeId, String location, String insuranceCompanyName, String family) {
        this.homeId = homeId;
        this.location = location;
        this.insuranceCompanyName = insuranceCompanyName;
        this.family = family;
    }

    private Long homeId;
    private String location;
    private String insuranceCompanyName;
    private String family;

    // Getters and setters]

    public Long getHomeId() {
        return homeId;
    }

    public void setHomeId(Long homeId) {
        this.homeId = homeId;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getInsuranceCompanyName() {
        return insuranceCompanyName;
    }

    public void setInsuranceCompanyName(String insuranceCompanyName) {
        this.insuranceCompanyName = insuranceCompanyName;
    }

    public String getFamily() {
        return family;
    }

    public void setFamily(String family) {
        this.family = family;
    }
}