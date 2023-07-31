package com.example.myofficeapplication2;


import com.example.myofficeapplication2.ModelResponse.RegisterResponse;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;






public interface RegisterInterface {
    @FormUrlEncoded
    @POST("register.php.txt")
    Call<RegisterResponse> register(

            @Field("Key_name") String name,

            @Field("Key_email") String email,

            @Field("Key_password") String password

    );



}




