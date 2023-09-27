package com.example.homebuilder.models;

public class HomeRebuild {
    private Long homeId;
    private Boolean isCritical;
    private Boolean success;
    private String startTime;
    private String endTime;

    public Long getHomeId() {
        return homeId;
    }

    public void setHomeId(Long homeId) {
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
