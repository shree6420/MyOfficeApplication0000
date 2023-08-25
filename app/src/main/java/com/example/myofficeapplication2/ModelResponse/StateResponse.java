package com.example.myofficeapplication2.ModelResponse;

import com.google.gson.annotations.SerializedName;

public class StateResponse {
    @SerializedName("Id")
    private int Id;
    @SerializedName("name")
    private String name;


    public StateResponse(int id, String name) {
        this.Id = id;
        this.name = name;
    }

    public int getId() {
        return Id;
    }

    public void setId(int id) {
        Id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
