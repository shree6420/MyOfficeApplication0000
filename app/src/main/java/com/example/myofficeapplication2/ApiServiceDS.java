package com.example.myofficeapplication2;

import com.example.myofficeapplication2.ModelResponse.DistrictResponse;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;

public interface ApiServiceDS {
    @FormUrlEncoded
    @GET("getdistricts.php")
    Call<DistrictResponse> getDistricts(
            @Field("key_Id")int Id,
            @Field("key_name")String name,
            @Field("key_state_id")int stateId
            );


    @FormUrlEncoded
    @GET("getstates.php")
    Call<List<String>> getStates(
            @Field("Key_id")int id,
            @Field("Key_name")String name


    );


    Call<List<String>> getDistricts(String selectedState);

    Call<List<String>> getStates();
}









