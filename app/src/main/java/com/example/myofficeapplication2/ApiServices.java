package com.example.myofficeapplication2;

import java.util.List;
import retrofit2.Call;

import retrofit2.http.GET;


public interface ApiServices {
        @GET("localhost://home.php.txt")
        Call<List<User>> getUsers();


    }

