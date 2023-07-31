package com.example.myofficeapplication2;

public class District {
    private String districtName;
    private int id;


    private int stateId;

    public District(String districtName, int id, int stateId) {
        this.districtName = districtName;
        this.id = id;
        this.stateId = stateId;


    }

    public String getDistrictName() {
        return districtName;
    }

    public void setDistrictName(String districtName) {
        this.districtName = districtName;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getStateId() {
        return stateId;
    }

    public void setStateId(int stateId) {
        this.stateId = stateId;
    }
}





