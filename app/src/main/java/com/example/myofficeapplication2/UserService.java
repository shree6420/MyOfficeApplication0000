package com.example.myofficeapplication2;

import com.example.myofficeapplication2.ModelResponse.LoginResponse;
import com.example.myofficeapplication2.ModelResponse.RegisterResponse;

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

