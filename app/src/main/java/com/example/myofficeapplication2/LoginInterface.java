package com.example.myofficeapplication2;

import com.example.myofficeapplication2.ModelResponse.LoginResponse;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

public interface LoginInterface {
    @FormUrlEncoded
    @POST("login.php.txt")
    Call<LoginResponse> loginuser(
          @Field("username") String username,
          @Field("password") String password




    );
}
