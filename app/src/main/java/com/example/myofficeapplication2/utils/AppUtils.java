package com.example.myofficeapplication2.utils;

import android.content.Intent;
import android.os.Handler;
import android.os.Looper;

import com.example.myofficeapplication2.activity.LoginActivity;

public class AppUtils {

    public interface DelayCallback{
        void afterDelay();
    }
    public static void delay(int secs, final DelayCallback delayCallback){
        new Handler(Looper.getMainLooper()).postDelayed(new Runnable() {
            @Override
            public void run() {
                delayCallback.afterDelay();
            }
        },700);
    }
}
