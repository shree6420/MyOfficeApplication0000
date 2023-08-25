package com.example.myofficeapplication2.ModelResponse;

import com.google.gson.annotations.SerializedName;

public class DistrictResponse {
 @SerializedName("Id")
 private int Id;
 @SerializedName("name")
 private String name;
 @SerializedName("state_id")
 private int state_id;

 public DistrictResponse(int id, String name, int state_id) {
  this.Id = id;
  this.name = name;
  this.state_id = state_id;

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

 public int getState_id() {
  return state_id;
 }

 public void setState_id(int state_id) {
  this.state_id = state_id;
 }
}


