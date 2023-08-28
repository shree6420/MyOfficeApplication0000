package com.example.myofficeapplication2.activity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;

import androidx.appcompat.app.AppCompatActivity;

import com.example.myofficeapplication2.R;
import com.example.myofficeapplication2.utils.AppUtils;

public class SplashActivity extends AppCompatActivity {

    private Context context;


    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        init();
    }
    private void init(){
        context = this;
        AppUtils.delay(700, new AppUtils.DelayCallback() {
            @Override
            public void afterDelay() {
                startActivity(new Intent(context, LoginActivity.class));
            }
        });
    }
}
