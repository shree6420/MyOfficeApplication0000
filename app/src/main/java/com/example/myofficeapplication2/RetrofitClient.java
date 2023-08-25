package com.example.myofficeapplication2;

import java.io.IOException;

import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;






public class RetrofitClient {

    private static String BASE_URL = "localhost/userapi/register.php.txt";
    private static RetrofitClient retrofitClient;

    private static Retrofit retrofit;

    private OkHttpClient.Builder builder = new OkHttpClient.Builder();

    private HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor();


    private RetrofitClient() {




        builder.addInterceptor(interceptor);
        retrofit = new Retrofit.Builder()

                .baseUrl(BASE_URL)

                .addConverterFactory(GsonConverterFactory.create())

                .client(builder.build())

                .build();


    }

    public static synchronized RetrofitClient getInstance() {


        if (retrofitClient == null) {

            retrofitClient = new RetrofitClient();

        }

        return retrofitClient;

    }


    public RegisterInterface getApi() {

        return retrofit.create(RegisterInterface.class);

    }


    private class HttpLoggingInterceptor implements Interceptor {
        @Override
        public Response intercept(Chain chain) throws IOException {
            return null;
        }
    }
}

