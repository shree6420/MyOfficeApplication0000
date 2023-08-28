package com.example.myofficeapplication2.webservice;

import com.example.myofficeapplication2.ModelResponse.LoginResponse;
import com.example.myofficeapplication2.ModelResponse.RegisterResponse;
import com.example.myofficeapplication2.model.RegisterRequest;
import com.example.myofficeapplication2.model.LoginRequest;
import com.example.myofficeapplication2.model.User;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;

public interface UserService {
    @POST("authenticate/")
    Call<LoginResponse> userLogin(@Body LoginRequest loginRequest);

    @POST("register/")
    Call<RegisterResponse>registerusers(@Body RegisterRequest registerRequest);

    @GET("user/")
    Call<User>getUser();


}

