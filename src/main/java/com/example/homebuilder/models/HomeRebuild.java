package com.example.homebuilder.models;

public class HomeRebuild {
    private int homeId;
    private Boolean isCritical;
    private Boolean success;
    private String startTime;
    private String endTime;

    public HomeRebuild(int homeId, Boolean isCritical, Boolean success, String startTime, String endTime) {
        this.homeId = homeId;
        this.isCritical = isCritical;
        this.success = success;
        this.startTime = startTime;
        this.endTime = endTime;
    }

    public int getHomeId() {
        return homeId;
    }

    public void setHomeId(int homeId) {
        this.homeId = homeId;
    }

    public Boolean getCritical() {
        return isCritical;
    }

    public void setCritical(Boolean critical) {
        isCritical = critical;
    }

    public Boolean getSuccess() {
        return success;
    }

    public void setSuccess(Boolean success) {
        this.success = success;
    }

    public String getStartTime() {
        return startTime;
    }

    public void setStartTime(String startTime) {
        this.startTime = startTime;
    }

    public String getEndTime() {
        return endTime;
    }

    public void setEndTime(String endTime) {
        this.endTime = endTime;
    }
}
